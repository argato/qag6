package tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.getDocx;

import java.io.IOException;
import org.junit.jupiter.api.Test;

public class DocxFileTests {

  @Test
  public void docxTest() throws IOException {
    String docFilePath =
        "https://github.com/argato/qag6/blob/master/src/test/resources/report.docx";
    String expectedDataHeader = "ОТЧЕТ ПО ИНЦИДЕНТУ № 20-11-50";
    String expectedDataHistory = "В систему добавлен новый инцидент № 20-11-50.";

    String actualData = getDocx(docFilePath);

    assertThat(actualData, containsString(expectedDataHeader));
    assertThat(actualData, containsString(expectedDataHistory));
  }
}
