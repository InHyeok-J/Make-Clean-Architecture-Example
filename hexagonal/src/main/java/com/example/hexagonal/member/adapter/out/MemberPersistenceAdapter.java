package com.example.hexagonal.member.adapter.out;

import com.example.hexagonal.member.application.port.out.LoadMemberPort;
import com.example.hexagonal.member.application.port.out.SaveMemberPort;
import com.example.hexagonal.member.domain.Member;
import com.example.hexagonal.member.domain.MemberId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class MemberPersistenceAdapter implements LoadMemberPort, SaveMemberPort {

  private final JpaMemberRepository jpaMemberRepository;
  private final MemberMapper memberMapper;

  @Override
  public boolean existByEmail(String email) {
    return jpaMemberRepository.existsByEmail(email);
  }

  @Override
  public Member loadMember(MemberId id) {
    JpaMemberEntity memberEntity = jpaMemberRepository.findById(id.value())
        .orElseThrow(() -> new IllegalStateException("유저 없음"));

    return memberMapper.mapToDomainMember(memberEntity);
  }

  @Override
  public void save(Member member) {
    jpaMemberRepository.save(memberMapper.mapToJpaMember(member));
  }
}
