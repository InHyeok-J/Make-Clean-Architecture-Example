package com.example.layed.member.api;

import com.example.layed.common.response.SuccessResponse;
import com.example.layed.member.domain.Token;
import com.example.layed.member.service.MemberService;
import com.example.layed.member.api.dto.LoginRequest;
import com.example.layed.member.api.dto.MemberResponse;
import com.example.layed.member.api.dto.RegisterMemberRequest;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberApi {

  private final MemberService memberService;

  @PostMapping("")
  public ResponseEntity<?> register(@Valid @RequestBody RegisterMemberRequest request) {
    memberService.registerMember(request);

    return SuccessResponse.withData("회원가입 성공");
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
    Token token = memberService.login(request);

    return SuccessResponse.withData(token);
  }

  @GetMapping("")
  public ResponseEntity<?> getMember() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    Long memberId = Long.valueOf(auth.getPrincipal().toString());
    MemberResponse result = memberService.getMember(memberId);
    return SuccessResponse.withData(result);
  }
}
