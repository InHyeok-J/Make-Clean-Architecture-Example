package com.example.hexagonal.member.adapter.out;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

interface JpaMemberRepository extends JpaRepository<JpaMemberEntity, Long> {
  boolean existsByEmail(String email);
  Optional<JpaMemberEntity> findByEmail(String email);
}
