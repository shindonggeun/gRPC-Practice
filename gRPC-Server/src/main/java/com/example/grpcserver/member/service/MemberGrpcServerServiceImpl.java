package com.example.grpcserver.member.service;

import com.example.grpcserver.member.MemberProto;
import com.example.grpcserver.member.MemberProto.MemberSignupRequestProto;
import com.example.grpcserver.member.MemberServiceGrpc;
import com.example.grpcserver.member.dto.MemberSignupRequest;
import com.example.grpcserver.member.entity.Member;
import com.example.grpcserver.member.mapper.MemberMapper;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class MemberGrpcServerServiceImpl extends MemberServiceGrpc.MemberServiceImplBase {

    private final MemberService memberService;
    private final MemberMapper memberMapper;

    @Override
    public void getMember(MemberProto.MemberRequestProto requestProto, StreamObserver<MemberProto.MemberResponseProto> responseObserver) {

        // 1. gRPC Client로부터 전달받은 request 데이터 처리
        Long memberId = requestProto.getMemberId();

        // 2. 서비스 레이어에서 request 데이터를 사용해서 데이터베이스에 저장된 회원 정보 가져오기 및 결과 반환
        Member member = memberService.getMember(memberId);
        MemberProto.MemberResponseProto responseProto = memberMapper.entityToProto(member);

        responseObserver.onNext(responseProto);
        responseObserver.onCompleted();
    }

    @Override
    public void signupMember(MemberSignupRequestProto signupRequestProto, StreamObserver<MemberProto.MemberResponseProto> responseObserver) {
        // 1. gRPC Client로부터 전달받은 request 데이터를 DTO로 변환
        MemberSignupRequest signupRequest = memberMapper.protoToDto(signupRequestProto);

        // 2. 서비스 레이어에서 request 데이터를 사용해서 데이터베이스에 저장하는 로직 수행 및 결과 반환
        Member member = memberService.signupMember(signupRequest);

        MemberProto.MemberResponseProto responseProto = memberMapper.entityToProto(member);

        responseObserver.onNext(responseProto);
        responseObserver.onCompleted();
    }

}
