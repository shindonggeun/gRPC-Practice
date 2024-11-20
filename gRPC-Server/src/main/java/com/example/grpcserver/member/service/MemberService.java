package com.example.grpcserver.member.service;

import com.example.grpcserver.member.dto.MemberSignupRequest;
import com.example.grpcserver.member.entity.Member;

public interface MemberService {

    Member getMember(Long memberId);

    Member signupMember(MemberSignupRequest signupRequest);
}
