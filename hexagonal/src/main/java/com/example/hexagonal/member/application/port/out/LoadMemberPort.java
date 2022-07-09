package com.example.hexagonal.member.application.port.out;

import com.example.hexagonal.member.domain.Member;
import com.example.hexagonal.member.domain.MemberId;

public interface LoadMemberPort {

  boolean existByEmail(String email);
  Member loadMember(MemberId id);
}
