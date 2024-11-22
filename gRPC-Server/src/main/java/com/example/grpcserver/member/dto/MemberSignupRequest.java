package com.example.grpcserver.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MemberSignupRequest {

    private String email;

    private String password;

    private String name;
}
