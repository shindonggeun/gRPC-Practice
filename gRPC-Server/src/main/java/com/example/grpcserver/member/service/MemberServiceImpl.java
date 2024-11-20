package com.example.grpcserver.member.service;

import com.example.grpcserver.member.dto.MemberSignupRequest;
import com.example.grpcserver.member.entity.Member;
import com.example.grpcserver.member.mapper.MemberMapper;
import com.example.grpcserver.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Override
    public Member getMember(Long memberId) {
        return null;
    }

    @Override
    public Member signupMember(MemberSignupRequest signupRequest) {
        Member member = memberMapper.dtoToEntity(signupRequest);
        return memberRepository.save(member);
    }
}
