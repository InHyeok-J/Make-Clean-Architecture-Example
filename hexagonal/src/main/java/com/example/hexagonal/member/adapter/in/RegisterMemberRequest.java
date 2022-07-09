package com.example.hexagonal.member.adapter.in;

public record RegisterMemberRequest(
    String email,
    String nickname,
    String password,
    int benchPressWeight,
    int deadLiftWeight,
    int squatWeight
) {

}
