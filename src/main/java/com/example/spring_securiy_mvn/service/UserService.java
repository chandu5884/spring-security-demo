package com.example.spring_securiy_mvn.service;

import com.example.spring_securiy_mvn.model.Users;
import com.example.spring_securiy_mvn.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepo userRepo;
  private final AuthenticationManager authenticationManager;
  private final JWTService jwtService;
  private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

  public Users register(Users user){
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    userRepo.save(user);
    return user;
  }

  public String verify(Users user){
    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken
            (user.getUsername(), user.getPassword()));
    if(authentication.isAuthenticated()) {
      return jwtService.generateToken(user.getUsername());
    }
    return "Failure";
  }
}
