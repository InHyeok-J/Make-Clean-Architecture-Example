package com.example.hexagonal.member.application.port.in;


import org.springframework.stereotype.Component;

@Component
public interface RegisterMemberUseCase {
  void register(RegisterMemberCommand command);
}
