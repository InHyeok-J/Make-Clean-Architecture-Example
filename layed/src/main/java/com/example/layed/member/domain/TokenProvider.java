package com.example.layed.member.domain;

import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenProvider {

  private final JwtProvider jwtProvider;

  public Token createToken(Long memberId, String email){
    Map<String, Object> payloads = new HashMap<>();
    payloads.put("memberId",memberId);
    payloads.put("email", email);

    String jwt = jwtProvider.accessToken(payloads);
    return new Token(jwt);
  }

}
