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
public class UserUpdateRequestDto {
  @NotBlank(message = "The email can not be empty")
  @Schema(description = "User Email", example = "email@gmail.com")
  @Email(message = "Invalid email format")
  private String email;
  @NotBlank(message = "The user name can not be empty")
  @Size(min = 3, message = "The user name must be at least 3 characters")
  @Schema(description = "User Name", example = "Jake")
  private String userName;
}
