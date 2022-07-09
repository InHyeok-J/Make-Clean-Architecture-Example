package com.example.hexagonal.member.application.port.out;

import com.example.hexagonal.member.domain.Member;

public interface SaveMemberPort {
  void save(Member member);
}
