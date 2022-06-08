package com.example.layed.member.web;

import com.example.layed.common.response.SuccessResponse;
import com.example.layed.member.domain.MemberService;
import com.example.layed.member.dto.RegisterMemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<?> register(@RequestBody RegisterMemberRequest request) {
    memberService.registerMember(request);

    return SuccessResponse.withData("회원가입 성공");
  }
}
