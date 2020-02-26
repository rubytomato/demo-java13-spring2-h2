package com.example.demo.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class BaseBackend {

  private ThreadLocal<MyData> list = new ThreadLocal<>();

  public MyData getMyData() {
    return list.get();
  }

  public void before(HttpServletRequest request, HttpServletResponse response) {
    LocalDateTime now = LocalDateTime.now();
    UUID uuid = UUID.randomUUID();
    list.set(new MyData(now, uuid));
    System.out.println("before:" + now.toString() + " uuid:" + uuid.toString());
  }

  public String after(HttpServletRequest request, HttpServletResponse response) {
    list.remove();
    String viewName = "account/login2";
    System.out.println("after:" + viewName);
    return viewName;
  }

  public RequestDto getRequestData(HttpServletRequest request) {
    try {
      return new RequestDto(request.getReader()
          .lines()
          .collect(Collectors.joining("\r\n")));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  static class RequestDto {
    String body;
  }

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  static class MyData {
    LocalDateTime now;
    UUID uuid;
  }

}
