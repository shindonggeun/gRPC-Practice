package com.example.grpcclient.member.service;

import com.example.grpcclient.member.MemberServiceProto.MemberResponse;
import com.example.grpcclient.member.MemberServiceProto.MemberSignupRequest;

public interface MemberGrpcClientService {

    MemberResponse getMember(Long memberId);

    MemberResponse signupMember(MemberSignupRequest signupRequest);
}
