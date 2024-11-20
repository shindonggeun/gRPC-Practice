package com.example.grpcserver.member.mapper;

import com.example.grpcserver.member.MemberProto;
import com.example.grpcserver.member.dto.MemberSignupRequest;
import com.example.grpcserver.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    // gRPC request를 dto로 변환
    MemberSignupRequest protoToDto(MemberProto.MemberSignupRequestProto memberSignupRequest);

    // dto를 Entity로 변환
    @Mapping(target = "id", ignore = true)
    Member dtoToEntity(MemberSignupRequest memberSignupRequest);

    // Entity를 gRPC response로 변환
    @Mapping(target = "memberId", source = "id")
    MemberProto.MemberResponseProto entityToProto(Member member);
}
