package com.example.hexagonal.member.application;

import com.example.hexagonal.common.error.BusinessException;
import com.example.hexagonal.member.application.port.in.LoginCommand;
import com.example.hexagonal.member.application.port.in.LoginUseCase;
import com.example.hexagonal.member.application.port.out.LoadMemberPort;
import com.example.hexagonal.member.domain.Member;
import com.example.hexagonal.member.domain.Token;
import com.example.hexagonal.member.domain.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
class LoginService implements LoginUseCase {

  private final LoadMemberPort loadMemberPort;
  private final TokenProvider tokenProvider;

  @Override
  public Token login(LoginCommand command) {
    Member member = loadMemberPort.loadMemberByEmail(command.getEmail());

    if(!member.getPassword().equals(command.getPassword())) {
      throw new BusinessException("패스워드가 일치하지 않습니다.", 400);
    }

    return tokenProvider.createToken(member.getMemberId(), member.getEmail());
  }
}
