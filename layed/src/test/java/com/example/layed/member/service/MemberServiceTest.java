package com.example.layed.member.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.example.layed.member.api.dto.LoginRequest;
import com.example.layed.member.api.dto.RegisterMemberRequest;
import com.example.layed.member.domain.TokenProvider;
import com.example.layed.member.domain.Member;
import com.example.layed.member.domain.MemberRepository;
import com.example.layed.member.domain.Token;
import com.example.layed.member.domain.exception.DuplicateMemberException;
import com.example.layed.member.domain.exception.NotMatchedPasswordException;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

  @Mock
  MemberRepository memberRepository;

  @Mock
  PasswordEncoder passwordEncoder;

  @Mock
  TokenProvider tokenProvider;

  @InjectMocks
  MemberService memberService;

  @Test
  @DisplayName("회원가입시 이메일 중복 실패")
  void singUpDuplicateEmail() {
    //given
    RegisterMemberRequest request = new RegisterMemberRequest("nickname", "email@email.com",
        "password");
    given(memberRepository.existsByEmail(any())).willReturn(true);
    //when
    Assertions.assertThrows(DuplicateMemberException.class,()->
        memberService.registerMember(request));
  }

  @Test
  @DisplayName("닉네임 중복실패")
  public void signUpDuplicateNickname() throws Exception {
    //given
    RegisterMemberRequest request = new RegisterMemberRequest("nickname", "email@email.com",
        "password");
    given(memberRepository.existsByEmail(any())).willReturn(false);
    given(memberRepository.existsByNickName(any())).willReturn(true);
    //when
    Assertions.assertThrows(DuplicateMemberException.class,()->
        memberService.registerMember(request));
  }

  @Test
  @DisplayName("로그인 패스워드 불일치")
  public void loginFail() throws Exception {
    //given
    LoginRequest request = new LoginRequest("email@email.com","password");

    given(memberRepository.findByEmail(request.getEmail())).willReturn(Optional.of(new Member()));
    given(passwordEncoder.matches(any(), any())).willReturn(false);
    //when
    Assertions.assertThrows(NotMatchedPasswordException.class,()->
        memberService.login(request));
  }

  @Test
  @DisplayName("로그인 성공")
  public void loginSuccess() throws Exception {
    //given
    LoginRequest request = new LoginRequest("email@email.com","password");

    given(memberRepository.findByEmail(request.getEmail())).willReturn(
        ofOptionalMember(request.getEmail(), "nickname2", request.getPassword()));
    given(passwordEncoder.matches(any(), any())).willReturn(true);
    given(tokenProvider.createToken(any(),any())).willReturn(new Token("token"));
    //when
    Token result = memberService.login(request);
    //then
    assertEquals("token", result.getAccessToken());
  }

  private Optional<Member> ofOptionalMember(String email, String nickname, String password){
    Member member = Member.builder()
        .email(email)
        .nickName(nickname)
        .password(password)
        .build();
    ReflectionTestUtils.setField(member,"id",1L);
    return Optional.of(member);
  }
}