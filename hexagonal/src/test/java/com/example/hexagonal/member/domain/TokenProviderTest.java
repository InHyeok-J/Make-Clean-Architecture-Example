package com.example.hexagonal.member.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TokenProviderTest {

  @Mock
  JwtProvider jwtProvider;

  @InjectMocks
  TokenProvider tokenProvider;

  @Test
  @DisplayName("token 생성시 jwt라이브러리 한번 호출")
  public void tokeProvider() throws Exception {
    //given
    MemberId id = new MemberId(1L);
    String email = "email@email.com";
    Map<String, Object> payload = new HashMap<>();
    payload.put("memberId", id.value());
    payload.put("email",email);
    //when
    Token token = tokenProvider.createToken(id, email);
    //then
    verify(jwtProvider, times(1)).accessToken(payload);
  }
}