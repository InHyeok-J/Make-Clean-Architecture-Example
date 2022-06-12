package com.example.layed.member.dto;

import com.example.layed.member.domain.Member;
import com.example.layed.member.persistence.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemberDto {

  private Long id;
  private String email;
  private String nickName;
  private String password;

  public MemberDto(MemberEntity entity) {
    this.id = entity.getId();
    this.email = entity.getEmail();
    this.nickName = entity.getNickName();
    this.password = entity.getPassword();
  }

  public Member toMember() {
    return Member.builder()
        .id(id)
        .nickname(nickName)
        .email(email)
        .password(password)
        .build();
  }
}
