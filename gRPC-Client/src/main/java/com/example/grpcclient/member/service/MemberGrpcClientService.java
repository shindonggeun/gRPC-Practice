package com.example.grpcclient.member.service;


import com.example.grpcclient.member.MemberProto;

public interface MemberGrpcClientService {

    MemberProto.MemberResponseProto getMember(Long memberId);

    MemberProto.MemberResponseProto signupMember(MemberProto.MemberSignupRequestProto signupRequest);
}
