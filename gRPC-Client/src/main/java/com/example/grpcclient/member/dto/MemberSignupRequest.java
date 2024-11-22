package com.example.grpcclient.member.dto;

public record MemberSignupRequest(
    String email,
    String password,
    String name
) {
}
