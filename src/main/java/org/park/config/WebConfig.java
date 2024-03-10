package org.park.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class WebConfig implements WebMvcConfigurer {
  LocalDate today = LocalDate.now();
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
  String dayPath = today.format(formatter);
  private String imgPath = "/upload/img/**";   //view에서 사용할 경로

  private String savePath = "file:///D:public/img/"+dayPath+"/";


  public void addResourceHandlers(ResourceHandlerRegistry registry){
    registry.addResourceHandler(imgPath).addResourceLocations(savePath);
  }
}
