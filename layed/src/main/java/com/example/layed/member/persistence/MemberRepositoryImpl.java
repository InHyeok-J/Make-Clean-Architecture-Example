package com.example.layed.member.persistence;

import com.example.layed.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

  private final JpaMemberRepository jpaMemberRepository;

  @Override
  public void registerMember(String email, String nickname, String password) {
    jpaMemberRepository.save(
        MemberEntity.builder().email(email).nickName(nickname).password(password)
            .build());
  }

  @Override
  public boolean existNickname(String nickname) {
    return jpaMemberRepository.existsByNickName(nickname);
  }

  @Override
  public boolean existEmail(String email) {
    return jpaMemberRepository.existsByEmail(email);
  }
}
