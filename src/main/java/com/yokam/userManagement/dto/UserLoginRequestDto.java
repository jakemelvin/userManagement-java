package com.yokam.userManagement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRequestDto {
  @NotBlank(message = "The email can not be empty")
  @Email(message = "Invalid email format")
  @Schema(description = "User Email", example = "email@gmail.com")
  private String email;
  @NotBlank(message = "The password can not be empty")
  @Size(min = 6, message = "The password must have at least 6 characters")
  @Schema(description = "User Password", example = "abracadrabra12@")
  private String password;
}
