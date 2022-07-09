package com.example.hexagonal.member.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberTest {

  @Test
  @DisplayName("Member 생성")
  public void createMember() throws Exception {
    String email = "email@email.com";
    String nickname = "nickname";
    String password = "password";
    SquatDeadBench sdb = new SquatDeadBench(100,200,300);

    Member member = Member.builder()
        .memberId(new MemberId(1L))
        .nickname("nickname")
        .email("email@email.com")
        .password("password")
        .sdb(sdb)
        .build();

    Assertions.assertEquals( 1L,member.getMemberId().value());
    Assertions.assertEquals( nickname,member.getNickname());
    Assertions.assertEquals( email,member.getEmail());
  }

  @Test
  @DisplayName("3대 중량 수정")
  public void changeWeight() throws Exception {
    //given
    String email = "email@email.com";
    String nickname = "nickname";
    String password = "password";
    SquatDeadBench sdb = new SquatDeadBench(100,200,300);
    SquatDeadBench changedSdb = new SquatDeadBench(200,200,100);
    Member member = Member.builder()
        .memberId(new MemberId(1L))
        .nickname("nickname")
        .email("email@email.com")
        .password("password")
        .sdb(sdb)
        .build();
    //when
    member.changeWeight(changedSdb);
    //then
    assertEquals( 200,member.getSdb().getSquatWeight());
  }
}