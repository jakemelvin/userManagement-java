package com.yokam.userManagement.service;

import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.yokam.userManagement.dto.UserCreationRequestDto;
import com.yokam.userManagement.dto.UserLoginRequestDto;
import com.yokam.userManagement.dto.UserUpdateRequestDto;
import com.yokam.userManagement.exception.ResourceNotFoundException;
import com.yokam.userManagement.mapper.UserMapper;
import com.yokam.userManagement.model.Users;
import com.yokam.userManagement.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
  private final UserRepository userRepository;
  private final AuthenticationManager authManager;
  private final JWTService jwtService;

  @Override
  public Users register(UserCreationRequestDto dto) {
    return userRepository.save(UserMapper.toEntity(dto));
  }

  @Override
  public String login(UserLoginRequestDto dto) {
    Authentication authentication = authManager
        .authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
    if (authentication.isAuthenticated()) {
      return jwtService.generateToken(dto.getEmail());
    }
    return "Authentication Failed";
  }

  @Override
  public List<Users> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public Users updateUser(UserUpdateRequestDto dto, Long userId) {
    Users userToUpdate = userRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found!"));
    userToUpdate.setEmail(dto.getEmail());
    userToUpdate.setUserName(dto.getUserName());
    return userRepository.save(userToUpdate);
  }

  @Override
  public void deleteUser(Long userId) {
    Users userToDelete = userRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    userRepository.delete(userToDelete);
  }

}
