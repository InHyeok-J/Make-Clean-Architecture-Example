package com.example.hexagonal.member.adapter.out;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "member")
@NoArgsConstructor
@Getter
class JpaMemberEntity {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_id")
  private Long id;

  @Column(name = "nickname", nullable = false)
  private String nickname;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name="password", nullable = false)
  private String password;

  @Column(name = "benchpress_weight", nullable = false)
  private int benchPressWeigh;

  @Column(name = "deadlift_weight", nullable = false)
  private int deadLiftWeight;

  @Column(name = "squat_weight",nullable = false)
  private int squatWeight;

  @Builder
  public JpaMemberEntity(Long id, String nickname, String email, String password,
      int benchPressWeigh,
      int deadLiftWeight, int squatWeight) {
    this.id = id;
    this.nickname = nickname;
    this.email = email;
    this.password = password;
    this.benchPressWeigh = benchPressWeigh;
    this.deadLiftWeight = deadLiftWeight;
    this.squatWeight = squatWeight;
  }
}
