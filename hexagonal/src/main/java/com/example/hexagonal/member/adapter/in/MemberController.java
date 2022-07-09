package com.example.hexagonal.member.adapter.in;

import com.example.hexagonal.common.response.JsonResponse;
import com.example.hexagonal.member.application.port.in.RegisterMemberCommand;
import com.example.hexagonal.member.application.port.in.RegisterMemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
class MemberController {

  private final RegisterMemberUseCase registerMemberUseCase;

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody RegisterMemberRequest request){
    RegisterMemberCommand command = new RegisterMemberCommand(
        request.nickname(),request.email(), request.password(),
        request.benchPressWeight(), request.deadLiftWeight(),request.squatWeight());
    registerMemberUseCase.register(command);

    return JsonResponse.ok(HttpStatus.CREATED);
  }
}
