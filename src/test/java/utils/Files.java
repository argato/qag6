package utils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Configuration;
import java.io.File;
import java.io.IOException;

public class Files {

  public static PDF getPdf(String path) throws IOException {
    return new PDF(downloadFile(path));
  }

  public static File downloadFile(String path) throws IOException {
    Configuration.downloadsFolder = "downloads";

    open(path);
    return $("#raw-url").download();
  }
}
