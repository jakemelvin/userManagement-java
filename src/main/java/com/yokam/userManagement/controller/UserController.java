package com.yokam.userManagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yokam.userManagement.dto.UserCreationRequestDto;
import com.yokam.userManagement.dto.UserLoginRequestDto;
import com.yokam.userManagement.dto.UserUpdateRequestDto;
import com.yokam.userManagement.mapper.UserMapper;
import com.yokam.userManagement.response.ApiResponse;
import com.yokam.userManagement.service.IUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/users")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "User Management Api", description = "An Api to manage the users from creation to login, to suppression")
public class UserController {
  private final IUserService userService;

  @PostMapping("/register")
  @Operation(summary = "An endpoint to create a user with their name, password and email")
  public ResponseEntity<ApiResponse> registerUser(@Valid @RequestBody UserCreationRequestDto dto) {
    return ResponseEntity
        .ok(new ApiResponse("User Created successfully", UserMapper.toUserResponse(userService.register(dto))));
  }

  @PostMapping("/login")
  @Operation(summary = "An endpoint to log in to the service and get a jwt key to be able to do all the other operations")
  public ResponseEntity<ApiResponse> logInUser(@Valid @RequestBody UserLoginRequestDto dto) {
    return ResponseEntity.ok(new ApiResponse("User login successful", userService.login(dto)));
  }

  @GetMapping
  @Operation(summary = "An endpoint to get all the users")
  public ResponseEntity<ApiResponse> getAllUsers() {
    return ResponseEntity
        .ok(new ApiResponse("Users fetched successfully", UserMapper.toUserResponseList(userService.getAllUsers())));
  }

  @PutMapping("/update")
  @Operation(summary = "An endpoint to update a user")
  public ResponseEntity<ApiResponse> updateUser(@Valid @RequestBody UserUpdateRequestDto dto,
      @RequestParam Long userId) {
    return ResponseEntity
        .ok(new ApiResponse("User updated successfully",
            UserMapper.toUserResponse(userService.updateUser(dto, userId))));
  }

  @DeleteMapping("/delete")
  @Operation(summary = "An endpoint to delete a user By his id")
  public ResponseEntity<ApiResponse> deleteUser(@RequestParam Long userId) {
    userService.deleteUser(userId);
    return ResponseEntity.ok(new ApiResponse("User deleted successfully", null));
  }
}
