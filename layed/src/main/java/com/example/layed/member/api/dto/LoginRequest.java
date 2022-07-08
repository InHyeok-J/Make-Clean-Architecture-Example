package com.example.layed.member.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginRequest {

  @Email
  @Size(max = 30)
  private String email;

  @NotBlank
  @Size(max = 30)
  @Pattern(regexp = "[a-zA-Z]*")
  private String password;
}
