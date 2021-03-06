package com.example.layed.member.domain;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
  boolean existsByEmail(String email);
  boolean existsByNickName(String nickname);
  Optional<Member> findByEmail(String email);
}
