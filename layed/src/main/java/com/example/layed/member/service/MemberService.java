package com.example.layed.member.service;

import com.example.layed.member.api.dto.LoginRequest;
import com.example.layed.member.api.dto.MemberResponse;
import com.example.layed.member.api.dto.RegisterMemberRequest;
import com.example.layed.member.domain.TokenProvider;
import com.example.layed.member.domain.Member;
import com.example.layed.member.domain.MemberRepository;
import com.example.layed.member.domain.Token;
import com.example.layed.member.domain.exception.DuplicateMemberException;
import com.example.layed.member.domain.exception.NotMatchedPasswordException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;
  private final TokenProvider tokenProvider;

  @Transactional
  public void registerMember(RegisterMemberRequest registerMemberRequest) {

    if(memberRepository.existsByEmail(registerMemberRequest.getEmail())){
      throw new DuplicateMemberException("이메일 중복");
    }

    if(memberRepository.existsByNickName(registerMemberRequest.getNickName())){
      throw new DuplicateMemberException("nickname 중복");
    }

    Member member = Member.builder().email(registerMemberRequest.getEmail())
                                    .nickName(registerMemberRequest.getNickName())
                                    .password(passwordEncoder.encode(registerMemberRequest.getPassword()))
                                    .build();
    memberRepository.save(member);
  }

  @Transactional(readOnly = true)
  public Token login(LoginRequest request){
    Member findMember = memberRepository.findByEmail(request.getEmail())
        .orElseThrow(()-> new IllegalStateException("유저가 없습니다"));

    if(!passwordEncoder.matches(request.getPassword(), findMember.getPassword())){
      throw new NotMatchedPasswordException("Password가 일치하지 않습니다.");
    }

    return tokenProvider.createToken(findMember.getId(), findMember.getEmail());
  }

  @Transactional
  public MemberResponse getMember(Long memberId){
    Member findMember = memberRepository.findById(memberId)
        .orElseThrow(()-> new IllegalStateException("유저가 없습니다"));

    return new MemberResponse(findMember.getId(), findMember.getNickName(), findMember.getEmail());
  }
}
