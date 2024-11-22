package com.example.grpcclient.member.dto;

import lombok.Builder;

@Builder
public record MemberResponse(
    Long id,
    String email,
    String name
) {

}
