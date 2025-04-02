package com.example.spring_securiy_mvn.service;

import com.example.spring_securiy_mvn.model.UserPrincipal;
import com.example.spring_securiy_mvn.model.Users;
import com.example.spring_securiy_mvn.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

  private final UserRepo userRepo;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Users user = userRepo.findByUsername(username);

    if(user == null){
      throw new UsernameNotFoundException("User not found");
    }
    return new UserPrincipal(user);
  }
}
