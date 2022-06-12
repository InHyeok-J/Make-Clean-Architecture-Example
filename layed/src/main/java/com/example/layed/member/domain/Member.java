package com.example.layed.member.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Member {

  private Long memberId;

  private String nickname;

  private String email;

  private String password;

  @Builder
  public Member(Long id,String nickname, String email, String password) {
    this.memberId = id;
    this.nickname = nickname;
    this.email = email;
    this.password = password;
  }
}
