package com.example.layed.member.dto;

import com.example.layed.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponse {

  private Long id;

  private String nickName;

  private String email;

  public static MemberResponse to(Member member) {
    return new MemberResponse(member.getMemberId(), member.getNickname(), member.getNickname());
  }
}
