package tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.getDoc;

import java.io.IOException;
import org.junit.jupiter.api.Test;

public class DocFileTests {

  @Test
  void docTest() throws IOException {

    String docFilePath =
        "https://github.com/argato/qag6/blob/master/src/test/resources/report.doc";
    String expectedDataHeader = "ОТЧЕТ ПО ИНЦИДЕНТУ № 20-11-50";
    String expectedDataHistory = "В систему добавлен новый инцидент № 20-11-50.";
    String text = getDoc(docFilePath);

    assertThat(text, containsString(expectedDataHeader));
    assertThat(text, containsString(expectedDataHistory));
  }

}