package com.example.grpcclient.member.service;

import com.example.grpcclient.member.MemberProto;
import com.example.grpcclient.member.MemberServiceGrpc;
import com.example.grpcclient.member.dto.MemberResponse;
import com.example.grpcclient.member.dto.MemberSignupRequest;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberGrpcClientServiceImpl implements MemberGrpcClientService {

    @GrpcClient("member-service") // gRPC 서버와의 연결 식별자
    private MemberServiceGrpc.MemberServiceBlockingStub memberServiceBlockingStub;

    @Override
    public MemberResponse getMember(Long memberId) {
        // gRPC 서버로 보내기 위해 DTO를 Protobuf 타입으로 변환
        MemberProto.MemberRequestProto request = MemberProto.MemberRequestProto.newBuilder()
            .setMemberId(memberId)
            .build();

        // gRPC 서버 호출
        MemberProto.MemberResponseProto memberResponseProto = memberServiceBlockingStub.getMember(request);

        // 해당 응답값 클라이언트(프론트단)에 보내줄 DTO로 변환
        return MemberResponse.builder()
            .id(memberResponseProto.getMemberId())
            .name(memberResponseProto.getName())
            .email(memberResponseProto.getEmail())
            .build();
    }

    @Override
    public MemberResponse signupMember(MemberSignupRequest signupRequest) {
        // gRPC 서버로 보내기 위해 DTO를 Protobuf 타입으로 변환
        MemberProto.MemberSignupRequestProto request = MemberProto.MemberSignupRequestProto.newBuilder()
            .setEmail(signupRequest.email())
            .setPassword(signupRequest.password())
            .setName(signupRequest.name())
            .build();


        // gRPC 서버 호출
        MemberProto.MemberResponseProto memberResponseProto = memberServiceBlockingStub.signupMember(request);

        // 해당 응답값 클라이언트(프론트단)에 보내줄 DTO로 변환
        return MemberResponse.builder()
            .id(memberResponseProto.getMemberId())
            .name(memberResponseProto.getName())
            .email(memberResponseProto.getEmail())
            .build();
    }

}
