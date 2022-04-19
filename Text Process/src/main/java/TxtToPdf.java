import com.itextpdf.text.*;

import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;

import static com.itextpdf.text.BaseColor.RED;


/**
 * @author 14811
 * @date 2022/4/15
 */
public class TxtToPdf {

    public void text2pdf(String textPath, String pdfPath) throws DocumentException, IOException {
        String cString = "数据";
        String color = "#FF0000";


        File text = new File(textPath);

        // 创建Document
        Document document = new Document(PageSize.A4, 80, 80, 60, 30);
        // 获得PdfWriter实例
        PdfWriter.getInstance(document, new FileOutputStream(pdfPath));

        document.open();

        // 创建字体
        BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font font = new Font(baseFont);
        font.setStyle(Font.NORMAL);
        font.setSize(11);

        Font colorFont = new Font(baseFont);
        colorFont.setColor(RED);
        font.setStyle(Font.NORMAL);
        font.setSize(11);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(text));
        String strLine;
        int start;
        int end = 0;

        while ((strLine = bufferedReader.readLine()) != null) {
            boolean contains = strLine.contains(cString);
            if (contains) {
                start = strLine.indexOf(cString, end);
                while (true) {
                    if (start == 0) {
                        end = start + cString.length();
                        String substring = strLine.substring(start, end);
                        Phrase colorParagraph = new Phrase(substring, colorFont);
                        document.add(colorParagraph);
                        start = end;
                        continue;
                    }

                    if (start == end) {
                        end = strLine.indexOf(cString, start);
                        if (end == -1) {
                            String substringLine = strLine.substring(start);
                            Phrase paragraphPre = new Phrase(substringLine + "\n", font);
                            document.add(paragraphPre);
                            break;
                        }
                        String substring = strLine.substring(start, end);
                        Phrase paragraphPre = new Phrase(substring, font);
                        document.add(paragraphPre);
                        start = end;
                        end = start + cString.length();
                        continue;
                    }

                    if (start > end) {
                        String substring = strLine.substring(end, start);
                        Phrase paragraphPre = new Phrase(substring, font);
                        document.add(paragraphPre);
                        end = start + cString.length();
                        continue;
                    }

                    String substring = strLine.substring(start, end);
                    Phrase colorParagraph = new Phrase(substring, colorFont);
                    document.add(colorParagraph);
                    start = end;
                }
            }
//            Paragraph paragraph = new Paragraph(strLine + "\n", font);
//            paragraph.setAlignment(Element.ALIGN_LEFT);
//            document.add(paragraph);
            end = 0;
        }

        document.close();
        bufferedReader.close();

        System.out.println("============Build Success！===========");
    }
}
