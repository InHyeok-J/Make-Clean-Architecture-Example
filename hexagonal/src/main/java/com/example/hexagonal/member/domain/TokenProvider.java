package com.example.hexagonal.member.domain;

import java.util.HashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenProvider {

  private final JwtProvider jwtProvider;

  public Token createToken(MemberId memberId, String email){

    HashMap<String, Object> paylpads = new HashMap<>();
    paylpads.put("memberId", memberId.value());
    paylpads.put("email", email);

    String jwt = jwtProvider.accessToken(paylpads);

    return new Token(jwt);
  }

}
