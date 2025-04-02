package com.example.spring_securiy_mvn.controller;

import com.example.spring_securiy_mvn.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

  public List<Student> students = List.of(
    new Student(1, "James Bond"),
    new Student(2, "Maria Jones"),
    new Student(3, "Anna Smith")
  );

  @GetMapping("/student")
  public List<Student> getStudents(){
    return students;
  }

}
