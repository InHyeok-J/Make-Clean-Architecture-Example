package com.example.hexagonal.member.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;

interface JpaMemberRepository extends JpaRepository<JpaMemberEntity, Long> {
  boolean existsByEmail(String email);
}
