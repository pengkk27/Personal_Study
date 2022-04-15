import com.itextpdf.text.*;

import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;


/**
 * @author 14811
 * @date 2022/4/15
 */
public class TxtToPdf {

    public void text2pdf(String textPath, String pdfPath) throws DocumentException, IOException {

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


        BufferedReader bufferedReader = new BufferedReader(new FileReader(text));
        String strLine;

        while ((strLine = bufferedReader.readLine()) != null) {
            Paragraph paragraph = new Paragraph(strLine + "\n", font);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            document.add(paragraph);
        }

        document.close();
        bufferedReader.close();

        System.out.println("============Build Success！===========");
    }
}
