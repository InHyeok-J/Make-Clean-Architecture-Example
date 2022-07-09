package com.example.hexagonal.member.application.port.in;

import com.example.hexagonal.common.SelfValidating;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = false)
public class RegisterMemberCommand extends SelfValidating<RegisterMemberCommand>{

  @NotBlank
  private final String nickname;

  @NotBlank
  @Email
  private final String email;

  @NotBlank
  private final String password;

  @Positive
  private final int benchPressWeight;

  @Positive
  private final int deadLiftWeight;

  @Positive
  private final int squatWeight;

  public RegisterMemberCommand(String nickname, String email, String password, int benchPressWeight,
      int deadLiftWeight, int squatWeight) {
    this.nickname = nickname;
    this.email = email;
    this.password = password;
    this.benchPressWeight = benchPressWeight;
    this.deadLiftWeight = deadLiftWeight;
    this.squatWeight = squatWeight;
    this.validateSelf();
  }

}
