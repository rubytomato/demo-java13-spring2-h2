package com.example.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "app")
public class AppController {

  @Autowired
  ObjectMapper objectMapper;

  @GetMapping
  public String index(Model model) {
    List<KotobaBean> list = List.of(
      new KotobaBean(1L, "走る", "run", "動詞"),
      new KotobaBean(2L, "歩く", "walk", "動詞"),
      new KotobaBean(3L, "鉛筆", "pencil", "名詞"),
      new KotobaBean(4L, "夢", "dream", "名詞")
    );
    model.addAttribute("list", list);
    String json = toJson(list);
    model.addAttribute("json", json);
    return "app";
  }

  private String toJson(List<KotobaBean> list) {
    ObjectMapper mapper = new ObjectMapper()
        .disable(SerializationFeature.INDENT_OUTPUT);
    try {
      String value = mapper.writeValueAsString(list);
      System.out.println(value);
      return value;
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  static class KotobaBean {
    Long id;
    String japanese;
    String english;
    String pos;
  }

}
