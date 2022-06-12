package com.example.layed.member.web;

import com.example.layed.common.response.SuccessResponse;
import com.example.layed.member.domain.MemberService;
import com.example.layed.member.dto.LoginRequest;
import com.example.layed.member.dto.MemberResponse;
import com.example.layed.member.dto.RegisterMemberRequest;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request){
    memberService.login(request);

    return SuccessResponse.withData("로그인 성공");
  }

  @GetMapping("")
  public ResponseEntity<?> getMember(){
    MemberResponse result = memberService.getMember();
    return SuccessResponse.withData(result);
  }
}
