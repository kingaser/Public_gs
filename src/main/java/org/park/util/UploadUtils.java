package org.park.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
public class UploadUtils {

  @Value("${upload.path}")
  private String uploadPath;

  private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

  public void upload(String fileName) {
    /*

    upload 로직
     */
    LocalDate today = LocalDate.now();
    String dayPath = today.format(formatter);

    String fullPath = String.format("%s%s", uploadPath, dayPath);
//    StringBuilder


  }
}
