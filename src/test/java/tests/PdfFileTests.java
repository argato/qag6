package tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static utils.Files.getPdf;

import com.codeborne.pdftest.PDF;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class PdfFileTests {

  @Test
  void pdfTest() throws IOException {
    String pdfFilePath = "https://github.com/argato/qag6/blob/master/src/test/resources/report.pdf";
    String expectedData = "ОТЧЕТ ПО ИНЦИДЕНТУ № 20-11-26";

    PDF pdf = getPdf(pdfFilePath, false);
    assertThat(pdf, PDF.containsText(expectedData));
  }
}
