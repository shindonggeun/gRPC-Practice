package com.example.grpcclient.member.service;

import com.example.grpcclient.member.MemberProto;
import com.example.grpcclient.member.MemberServiceGrpc;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberGrpcClientServiceImpl implements MemberGrpcClientService {

    @GrpcClient("member-service") // gRPC 서버와의 연결 식별자
    private MemberServiceGrpc.MemberServiceBlockingStub memberServiceBlockingStub;

    @Override
    public MemberProto.MemberResponseProto getMember(Long memberId) {
        MemberProto.MemberRequestProto request = MemberProto.MemberRequestProto.newBuilder()
            .setMemberId(memberId)
            .build();

        MemberProto.MemberResponseProto memberResponse = memberServiceBlockingStub.getMember(request);

        log.info(memberResponse.toString());

        // gRPC 서버 호출
        return memberResponse;
    }

    @Override
    public MemberProto.MemberResponseProto signupMember(MemberProto.MemberSignupRequestProto signupRequest) {
        MemberProto.MemberResponseProto memberResponse = memberServiceBlockingStub.signupMember(signupRequest);

        log.info(memberResponse.toString());

        return memberResponse;
    }

}
