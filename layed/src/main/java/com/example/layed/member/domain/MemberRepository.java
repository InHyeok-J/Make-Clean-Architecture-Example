package com.example.layed.member.domain;

import org.springframework.stereotype.Component;

@Component
public interface MemberRepository {

  boolean existNickname(String nickname);

  boolean existEmail(String email);

  void registerMember(String email, String nickName, String password);
}
