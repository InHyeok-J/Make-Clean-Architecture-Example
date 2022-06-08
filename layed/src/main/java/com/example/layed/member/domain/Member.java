package com.example.layed.member.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Member {

  private String nickname;

  private String email;

  private String password;

  @Builder
  public Member(String nickname, String email, String password) {
    this.nickname = nickname;
    this.email = email;
    this.password = password;
  }
}
