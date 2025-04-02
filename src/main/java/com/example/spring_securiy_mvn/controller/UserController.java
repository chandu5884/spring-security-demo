package com.example.spring_securiy_mvn.controller;

import com.example.spring_securiy_mvn.model.Users;
import com.example.spring_securiy_mvn.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("/register")
  public Users register(@RequestBody Users user){
    return userService.register(user);
  }

  @PostMapping("/login")
  public String login(@RequestBody Users user){
    return userService.verify(user);
  }
}
