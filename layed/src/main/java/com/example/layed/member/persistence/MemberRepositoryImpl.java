package com.example.layed.member.persistence;

import com.example.layed.common.exception.NotExistEntityException;
import com.example.layed.member.domain.Member;
import com.example.layed.member.domain.MemberRepository;
import com.example.layed.member.dto.MemberDto;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
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

  @Override
  public MemberDto findById(Long id) {
    return toMemberDto(jpaMemberRepository.findById(id));
  }

  @Override
  public MemberDto findByEmail(String email) {
    return toMemberDto(jpaMemberRepository.findByEmail(email));
  }

  private MemberDto toMemberDto(Optional<MemberEntity> entity) {
    return new MemberDto(
        entity.orElseThrow(() -> new NotExistEntityException("Member가 존재하지 않습니다.")));
  }
}
