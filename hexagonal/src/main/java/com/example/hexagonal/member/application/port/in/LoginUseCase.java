package com.example.hexagonal.member.application.port.in;

import com.example.hexagonal.member.domain.Token;
import org.springframework.stereotype.Component;

@Component
public interface LoginUseCase {
  Token login(LoginCommand command);
}
