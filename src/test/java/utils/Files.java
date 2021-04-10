package utils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Configuration;
import com.codeborne.xlstest.XLS;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Files {

  public static PDF getPdf(String path, boolean isLocal) throws IOException {
    return isLocal ? new PDF(downLoadLocalFile(path)) : new PDF(downloadFile(path));
  }

  public static XLS getXls(String path) throws IOException {
    return new XLS(downloadFile(path));
  }

  public static File downloadFile(String path) throws IOException {
    Configuration.downloadsFolder = "downloads";
    open(path);
    return $("#raw-url").download();
  }

  public static File downLoadLocalFile(String path) {
    return new File(path);
  }

  public static String getDocx(String path) throws IOException {
    File file = downloadFile(path);
    FileInputStream fis = new FileInputStream(file.getAbsolutePath());
    XWPFDocument docx = new XWPFDocument(fis);
    XWPFWordExtractor extractor = new XWPFWordExtractor(docx);
    fis.close();
    return extractor.getText();
  }

  public static String getDoc(String path) throws IOException {
    File file = downloadFile(path);
    FileInputStream fis = new FileInputStream(file.getAbsolutePath());
    HWPFDocument document = new HWPFDocument(fis);
    WordExtractor extractor = new WordExtractor(document);
    fis.close();
    return extractor.getText();
  }
}
