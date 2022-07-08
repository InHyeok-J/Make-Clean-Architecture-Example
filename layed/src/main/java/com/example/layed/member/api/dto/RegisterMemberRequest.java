package com.example.layed.member.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterMemberRequest {

  @NotBlank
  @Size(max = 20)
  private String nickName;

  @Email
  @Size(max = 30)
  private String email;

  @NotBlank
  @Size(max = 30)
  @Pattern(regexp = "[a-zA-Z]{0,}")
  private String password;

}
