package com.example.grpcclient.member.service;


import com.example.grpcclient.member.dto.MemberResponse;
import com.example.grpcclient.member.dto.MemberSignupRequest;

public interface MemberGrpcClientService {

    MemberResponse getMember(Long memberId);

    MemberResponse signupMember(MemberSignupRequest signupRequest);
}
