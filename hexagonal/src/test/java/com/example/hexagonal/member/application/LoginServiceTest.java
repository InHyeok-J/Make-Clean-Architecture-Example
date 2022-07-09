package com.example.hexagonal.member.application;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.example.hexagonal.common.error.BusinessException;
import com.example.hexagonal.member.application.port.in.LoginCommand;
import com.example.hexagonal.member.application.port.out.LoadMemberPort;
import com.example.hexagonal.member.domain.Member;
import com.example.hexagonal.member.domain.MemberId;
import com.example.hexagonal.member.domain.SquatDeadBench;
import com.example.hexagonal.member.domain.TokenProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LoginServiceTest {

  @Mock
  LoadMemberPort loadMemberPort;

  @InjectMocks
  LoginService loginService;

  @Mock
  TokenProvider tokenProvider;

  @Test
  @DisplayName("패스워드 불일치")
  public void loginFailByPassword() throws Exception {
    //given
    LoginCommand command = new LoginCommand("email@email.com", "password");
    SquatDeadBench sdb = new SquatDeadBench(100,200,300);
    Member member = Member.builder()
        .memberId(new MemberId(1L))
        .nickname("nickname")
        .email("email@email.com")
        .password("password2")
        .sdb(sdb)
        .build();
    given(loadMemberPort.loadMemberByEmail(command.getEmail()))
        .willReturn(member);
    //when
    BusinessException e = assertThrows(BusinessException.class,
        ()-> loginService.login(command));
    //then
    assertEquals("패스워드가 일치하지 않습니다.",e.getMessage());
  }

  @Test
  @DisplayName("로그인 성공")
  public void loginSuccess() throws Exception {
    //given
    LoginCommand command = new LoginCommand("email@email.com", "password");
    SquatDeadBench sdb = new SquatDeadBench(100,200,300);
    Member member = Member.builder()
        .memberId(new MemberId(1L))
        .nickname("nickname")
        .email("email@email.com")
        .password("password")
        .sdb(sdb)
        .build();
    given(loadMemberPort.loadMemberByEmail(command.getEmail()))
        .willReturn(member);
    //when
    loginService.login(command);
    //then
    verify(tokenProvider, times(1))
        .createToken(member.getMemberId(), member.getEmail());
  }
}