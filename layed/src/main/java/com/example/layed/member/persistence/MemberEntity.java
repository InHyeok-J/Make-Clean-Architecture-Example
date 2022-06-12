package com.example.layed.member.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "member")
public class MemberEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "nick_name", nullable = false)
  private String nickName;

  @Column(nullable = false)
  private String password;

  @Builder
  MemberEntity(String email, String nickName, String password) {
    this.email = email;
    this.nickName = nickName;
    this.password = password;
  }
}
