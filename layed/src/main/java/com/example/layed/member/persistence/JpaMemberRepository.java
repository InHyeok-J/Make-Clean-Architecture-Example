package com.example.layed.member.persistence;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMemberRepository extends JpaRepository<MemberEntity, Long> {
  boolean existsByEmail(String email);
  boolean existsByNickName(String nickname);
  Optional<MemberEntity> findByEmail(String email);
}
