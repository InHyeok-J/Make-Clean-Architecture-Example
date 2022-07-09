package com.example.hexagonal.member.application.port.in;

import com.example.hexagonal.common.SelfValidating;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = false)
public class LoginCommand extends SelfValidating<LoginCommand> {

  @NotBlank
  @Email
  private String email;

  @NotBlank
  private String password;

  public LoginCommand(String email, String password) {
    this.email = email;
    this.password = password;
    this.validateSelf();
  }
}
