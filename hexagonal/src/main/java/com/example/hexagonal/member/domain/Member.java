package com.example.hexagonal.member.domain;


import lombok.Builder;
import lombok.Getter;

@Getter
public class Member {

  private MemberId memberId;

  private SquatDeadBench sdb;

  private String email;

  private String password;

  private String nickname;

  @Builder
  public Member(MemberId memberId, SquatDeadBench sdb, String email, String password,
      String nickname) {
    this.memberId = memberId;
    this.sdb = sdb;
    this.email = email;
    this.password = password;
    this.nickname = nickname;
  }

  public void changeWeight(SquatDeadBench sdb){
    this.sdb = sdb;
  }
}
