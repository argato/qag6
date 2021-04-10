package tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static utils.Files.getPdf;
import static utils.Zip.unzip;

import com.codeborne.pdftest.PDF;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class ZipFileTests {

  @Test
  void zipWithPasswordPdfTest() throws IOException {
    String zipFilePath = "https://github.com/argato/qag6/blob/master/src/test/resources/report.zip";
    String unzipFolderPath = "./src/test/resources/files/unzip";
    String zipPassword = "1234";
    String unzipPdfFilePath = "./src/test/resources/files/unzip/report.pdf";
    String expectedData = "ОТЧЕТ ПО ИНЦИДЕНТУ № 20-11-26";

    unzip(zipFilePath, unzipFolderPath, zipPassword);
    PDF actualData = getPdf(unzipPdfFilePath, true);

    assertThat(actualData, PDF.containsText(expectedData));
  }
}
