package com.example.hexagonal.member.application;

import com.example.hexagonal.common.error.BusinessException;
import com.example.hexagonal.member.application.port.in.RegisterMemberCommand;
import com.example.hexagonal.member.application.port.in.RegisterMemberUseCase;
import com.example.hexagonal.member.application.port.out.LoadMemberPort;
import com.example.hexagonal.member.application.port.out.SaveMemberPort;
import com.example.hexagonal.member.domain.Member;
import com.example.hexagonal.member.domain.SquatDeadBench;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class RegisterMemberService implements RegisterMemberUseCase {

  private final LoadMemberPort loadMemberPort;
  private final SaveMemberPort saveMemberPort;

  @Override
  public void register(RegisterMemberCommand command) {
    if(loadMemberPort.existByEmail(command.getEmail())){
      throw new BusinessException("이미 존재하는 유저입니다.", 400);
    }

    Member member = Member.builder()
        .email(command.getEmail())
        .nickname(command.getNickname())
        .password(command.getPassword())
        .sdb(new SquatDeadBench(command.getSquatWeight(), command.getDeadLiftWeight(), command.getBenchPressWeight()))
        .build();

    saveMemberPort.save(member);
  }
}
