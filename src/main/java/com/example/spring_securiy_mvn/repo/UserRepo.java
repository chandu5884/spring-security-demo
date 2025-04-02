package com.example.spring_securiy_mvn.repo;

import com.example.spring_securiy_mvn.model.Users;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

@Configuration
public interface UserRepo extends JpaRepository<Users, Integer> {

  Users findByUsername(String username);
}
