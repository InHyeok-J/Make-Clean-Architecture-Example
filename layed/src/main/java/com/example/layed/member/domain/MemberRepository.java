package com.example.layed.member.domain;

import com.example.layed.member.dto.MemberDto;
import org.springframework.stereotype.Component;

@Component
public interface MemberRepository {

  boolean existNickname(String nickname);

  boolean existEmail(String email);

  void registerMember(String email, String nickName, String password);

  MemberDto findById(Long id);

  MemberDto findByEmail(String email);
}
