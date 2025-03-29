package com.yokam.userManagement.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yokam.userManagement.model.Users;
import com.yokam.userManagement.model.UserPrincipal;
import com.yokam.userManagement.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Users user = userRepository.findByEmail(email);
    if (user == null) {
      System.out.println("User not found");
      throw new UsernameNotFoundException("User not found");
    }
    return new UserPrincipal(user);
  }

}
