package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class LoginController {

  @Autowired
  private BaseBackend baseBackend;

  @RequestMapping("/login")
  String execute(Model model) {
    BaseBackend.MyData myData = baseBackend.getMyData();
    System.out.println("login controller uuid:" + myData.getUuid().toString());
    return "account/login";
  }

  @RequestMapping("/login2")
  void execute2() {
    System.out.println("login2 controller");
  }

}
