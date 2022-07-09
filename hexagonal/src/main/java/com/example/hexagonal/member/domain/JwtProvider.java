package com.example.hexagonal.member.domain;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {

  private final String SECRET_KEY = "jwtsecretkey";

  public String accessToken(Map<String,Object> payload){
    return Jwts.builder()
        .setClaims(payload)
        .setExpiration(Date.from(Instant.now().plus(30, ChronoUnit.MINUTES)))
        .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
        .compact();

  }
}
