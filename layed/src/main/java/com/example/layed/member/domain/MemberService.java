package com.example.layed.member.domain;

import com.example.layed.member.domain.exception.DuplicateMemberException;
import com.example.layed.member.domain.exception.NotMatchedPasswordException;
import com.example.layed.member.dto.LoginRequest;
import com.example.layed.member.dto.MemberDto;
import com.example.layed.member.dto.MemberResponse;
import com.example.layed.member.dto.RegisterMemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;
  private final SessionManager sessionManager;

  @Transactional
  public void registerMember(RegisterMemberRequest registerMemberRequest) {

    if (memberRepository.existNickname(registerMemberRequest.getNickName())
        || memberRepository.existEmail(registerMemberRequest.getEmail())) {
      throw new DuplicateMemberException("제약 사항 중복");
    }

    memberRepository.registerMember(registerMemberRequest.getEmail(),
        registerMemberRequest.getNickName(),
        passwordEncoder.encode(registerMemberRequest.getPassword()));
  }

  @Transactional
  public void login(LoginRequest request){
    Member findMember = memberRepository.findByEmail(request.getEmail()).toMember();

    if(!passwordEncoder.matches(request.getPassword(), findMember.getPassword())){
      throw new NotMatchedPasswordException("Password가 일치하지 않습니다.");
    }

    sessionManager.saveSession(findMember.getMemberId());
  }

  @Transactional
  public MemberResponse getMember(){
    Long memberId = sessionManager.getUserId();

    Member findMember = memberRepository.findById(memberId).toMember();

    return MemberResponse.to(findMember);
  }
}
