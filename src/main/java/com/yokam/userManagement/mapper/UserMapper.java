package com.yokam.userManagement.mapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.yokam.userManagement.dto.UserCreationRequestDto;
import com.yokam.userManagement.dto.UserResponseDto;
import com.yokam.userManagement.model.Users;

public class UserMapper {
  private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

  public static Users toEntity(UserCreationRequestDto dto) {
    Users user = new Users();
    user.setEmail(dto.getEmail());
    user.setPassword(encoder.encode(dto.getPassword()));
    user.setUserName(dto.getUserName());
    return user;
  }

  public static UserResponseDto toUserResponse(Users user) {
    UserResponseDto dto = new UserResponseDto();
    dto.setId(user.getId());
    dto.setEmail(user.getEmail());
    dto.setUserName(user.getUserName());
    return dto;
  }

  public static Set<UserResponseDto> toUserResponseList(List<Users> users) {
    Set<UserResponseDto> dtoList = new HashSet<>();
    users.forEach(user -> {
      dtoList.add(toUserResponse(user));
    });
    return dtoList;
  }
}
