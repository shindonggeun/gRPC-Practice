package com.example.grpcclient.member.service;

import com.example.grpcclient.member.MemberServiceGrpc;
import com.example.grpcclient.member.MemberServiceProto.MemberRequest;
import com.example.grpcclient.member.MemberServiceProto.MemberResponse;
import com.example.grpcclient.member.MemberServiceProto.MemberSignupRequest;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class MemberGrpcClientServiceImpl implements MemberGrpcClientService {

    @GrpcClient("member-service") // gRPC 서버와의 연결 식별자
    private MemberServiceGrpc.MemberServiceBlockingStub memberServiceBlockingStub;

    @Override
    public MemberResponse getMember(Long memberId) {
        MemberRequest request = MemberRequest.newBuilder()
            .setMemberId(memberId)
            .build();

        // gRPC 서버 호출
        return memberServiceBlockingStub.getMember(request);
    }

    @Override
    public MemberResponse signupMember(MemberSignupRequest signupRequest) {
        // gRPC 서버 호출
        return memberServiceBlockingStub.signupMember(signupRequest);
    }
}
