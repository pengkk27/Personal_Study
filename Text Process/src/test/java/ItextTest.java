import org.junit.Test;

/**
 * @author 14811
 * @date 2022/4/15
 */
public class ItextTest {

    @Test
    public void textToPdf() {
        TxtToPdf txtToPdf = new TxtToPdf();
        String text = "F:/text_test.txt";
        String pdf = "F:/text_test.pdf";
        try {
            txtToPdf.text2pdf(text, pdf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
