package com.yokam.userManagement.service;

import java.util.List;

import com.yokam.userManagement.dto.UserCreationRequestDto;
import com.yokam.userManagement.dto.UserLoginRequestDto;
import com.yokam.userManagement.dto.UserUpdateRequestDto;
import com.yokam.userManagement.model.Users;

public interface IUserService {
  Users register(UserCreationRequestDto dto);

  String login(UserLoginRequestDto dto);

  List<Users> getAllUsers();

  Users updateUser(UserUpdateRequestDto dto,Long userId);

  void deleteUser(Long userId);
}
