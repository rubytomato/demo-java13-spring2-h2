package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping(value = "user")
@Slf4j
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(value = "/{id}")
  public String index(@PathVariable("id") Long id, Model model) {
    Optional<User> optionalUser = userService.findById(id);
    User user = optionalUser.orElseThrow(RuntimeException::new);
    model.addAttribute("user", user);
    return "user/index";
  }

}
