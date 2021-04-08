package tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.Files.getXls;

import com.codeborne.xlstest.XLS;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class XlsxFileTests {

  @Test
  void xlsxTest() throws IOException {
    String xlsxFilePath =
        "https://github.com/argato/qag6/blob/master/src/test/resources/report.xlsx";
    String expectedData = "Инциденты по сотрудникам. Отчетный период: 2020-08-01 - 2020-08-31";

    XLS xlsx = getXls(xlsxFilePath);
    assertThat(xlsx, XLS.containsText(expectedData));
  }

  @Test
  void xlsxCellsTest() throws IOException {
    String xlsxFilePath =
        "https://github.com/argato/qag6/blob/master/src/test/resources/report.xlsx";
    String reportHeader = "Инциденты по сотрудникам. Отчетный период: 2020-08-01 - 2020-08-31";
    String column0 = "Сотрудники";
    String column1 = "Всего";
    String column2 = "Статус инцидента";
    String column3 = "Закрытые";
    String column4 = "В работе";
    String column5 = "Уровень критичности";
    String column6 = "Критичный";
    String column7 = "Высокий";
    String column8 = "Средний";
    String column9 = "новый";
    String column10 = "Незначительный";
    String column11 = "ааа";
    int columnCount = 9;
    int reportRowsCount = 2;
    int reportStartRowIndex = 4;
    ArrayList<ArrayList<String>> rows = new ArrayList<>(reportRowsCount);
    rows.add(new ArrayList<>(
        Arrays.asList("Иванов Иван", "1.0", "0.0", "1.0", "0.0", "0.0", "1.0", "0.0", "0.0",
                      "0.0")));
    rows.add(new ArrayList<>(
        Arrays.asList("Sidorov Sidr", "3.0", "1.0", "2.0", "0.0", "1.0", "1.0", "0.0", "1.0",
                      "0.0")));
    ArrayList<String> rowDataFromFile = new ArrayList<>();
    ArrayList<ArrayList<String>> rowsDataFromFile = new ArrayList<>(reportRowsCount);
    XLS xls = getXls(xlsxFilePath);
    assertEquals(reportHeader, xls.excel.getSheet("Отчет").getRow(0).getCell(0).toString());
    assertEquals(column0, xls.excel.getSheet("Отчет").getRow(2).getCell(0).toString());
    assertEquals(column1, xls.excel.getSheet("Отчет").getRow(2).getCell(1).toString());
    assertEquals(column2, xls.excel.getSheet("Отчет").getRow(2).getCell(2).toString());
    assertEquals(column3, xls.excel.getSheet("Отчет").getRow(3).getCell(2).toString());
    assertEquals(column4, xls.excel.getSheet("Отчет").getRow(3).getCell(3).toString());
    assertEquals(column5, xls.excel.getSheet("Отчет").getRow(2).getCell(4).toString());
    assertEquals(column6, xls.excel.getSheet("Отчет").getRow(3).getCell(4).toString());
    assertEquals(column7, xls.excel.getSheet("Отчет").getRow(3).getCell(5).toString());
    assertEquals(column8, xls.excel.getSheet("Отчет").getRow(3).getCell(6).toString());
    assertEquals(column9, xls.excel.getSheet("Отчет").getRow(3).getCell(7).toString());
    assertEquals(column10, xls.excel.getSheet("Отчет").getRow(3).getCell(8).toString());
    assertEquals(column11, xls.excel.getSheet("Отчет").getRow(3).getCell(9).toString());

    for (int i = reportStartRowIndex; i < reportStartRowIndex + reportRowsCount; i++) {
      for (int j = 0; j <= columnCount; j++) {
        rowDataFromFile.add(xls.excel.getSheet("Отчет").getRow(i).getCell(j).toString());
      }
      rowsDataFromFile.add(new ArrayList<>(rowDataFromFile));
      rowDataFromFile.clear();
    }
    assertEquals(rows, rowsDataFromFile);

  }
}
