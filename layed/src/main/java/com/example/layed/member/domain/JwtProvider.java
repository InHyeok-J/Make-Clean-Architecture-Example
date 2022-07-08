package com.example.layed.member.domain;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
class JwtProvider {

  private final String SECRET_KEY;

  public JwtProvider() {
    this.SECRET_KEY = "jwtsecertkeyValue..";
  }

  public String accessToken(Map<String,Object> payload){
    return Jwts.builder()
        .setClaims(payload)
        .setExpiration(Date.from(Instant.now().plus(30, ChronoUnit.MINUTES)))
        .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
        .compact();

  }
}
