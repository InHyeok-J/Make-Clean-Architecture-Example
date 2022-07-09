package com.example.hexagonal.member.adapter.out;

import com.example.hexagonal.member.domain.Member;
import com.example.hexagonal.member.domain.MemberId;
import com.example.hexagonal.member.domain.SquatDeadBench;
import org.springframework.stereotype.Component;

@Component
class MemberMapper {

  Member mapToDomainMember(JpaMemberEntity jpaMember) {
    SquatDeadBench sdb = new SquatDeadBench(jpaMember.getSquatWeight(),
                                            jpaMember.getDeadLiftWeight(),
                                            jpaMember.getBenchPressWeigh());
    return Member.builder()
        .memberId(new MemberId(jpaMember.getId()))
        .email(jpaMember.getEmail())
        .nickname(jpaMember.getNickname())
        .password(jpaMember.getPassword())
        .sdb(sdb)
        .build();
  }

  JpaMemberEntity mapToJpaMember(Member member){
    return JpaMemberEntity.builder()
        .email(member.getEmail())
        .nickname(member.getNickname())
        .password(member.getPassword())
        .benchPressWeigh(member.getSdb().getBenchWeight())
        .deadLiftWeight(member.getSdb().getDeadWeight())
        .squatWeight(member.getSdb().getSquatWeight())
        .build();
  }
}
