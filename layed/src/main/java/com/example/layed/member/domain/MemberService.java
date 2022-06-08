package com.example.layed.member.domain;

import com.example.layed.member.domain.exception.DuplicateMemberException;
import com.example.layed.member.dto.RegisterMemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;
  private final MemberRequestValidator validator;
  private final PasswordEncoder passwordEncoder;

  @Transactional
  public void registerMember(RegisterMemberRequest registerMemberRequest) {
    validator.registerRequestValid(registerMemberRequest);

    if (memberRepository.existNickname(registerMemberRequest.getNickName())
        || memberRepository.existEmail(registerMemberRequest.getEmail())) {
      throw new DuplicateMemberException("제약 사항 중복");
    }

    memberRepository.registerMember(registerMemberRequest.getEmail(),
        registerMemberRequest.getNickName(),
        passwordEncoder.encode(registerMemberRequest.getPassword()));
  }
}
