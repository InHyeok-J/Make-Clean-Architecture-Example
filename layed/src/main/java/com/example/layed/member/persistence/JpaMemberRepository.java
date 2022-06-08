package com.example.layed.member.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMemberRepository extends JpaRepository<MemberEntity, Long> {
  boolean existsByEmail(String email);
  boolean existsByNickName(String nickname);
}
