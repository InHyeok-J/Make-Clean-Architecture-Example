package com.example.layed.member.domain;

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
  @DisplayName("JWT발급")
  public void createAccessToken() throws Exception {

    Token token = tokenProvider.createToken(1L, "email@email.com");
    Map<String, Object> payloads = new HashMap<>();
    payloads.put("memberId",1L);
    payloads.put("email", "email@email.com");

    verify(jwtProvider, times(1)).accessToken(payloads);
  }
}