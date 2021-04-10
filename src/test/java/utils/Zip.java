package utils;

import java.io.IOException;
import net.lingala.zip4j.ZipFile;

public class Zip {

  public static void unzip(String zipFilePath, String unzipFolderPath, String zipPassword)
      throws IOException {
    ZipFile zipFile = new ZipFile(Files.downloadFile(zipFilePath).getAbsolutePath());
    if (zipFile.isEncrypted()) {
      zipFile.setPassword(zipPassword.toCharArray());
    }
    zipFile.extractAll(unzipFolderPath);
  }
}
