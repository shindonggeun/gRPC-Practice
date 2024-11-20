package com.example.grpcclient.member.controller;

import com.example.grpcclient.member.MemberProto.MemberSignupRequestProto;
import com.example.grpcclient.member.service.MemberGrpcClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberGrpcClientService memberGrpcClientService;

    @GetMapping("/{memberId}")
    public ResponseEntity<String> getMember(@PathVariable("memberId") Long memberId) {
        return ResponseEntity.ok(memberGrpcClientService.getMember(memberId).getEmail());
    }

    @PostMapping
    public ResponseEntity<String> signupMember(MemberSignupRequestProto signupRequest) {
        return ResponseEntity.ok(memberGrpcClientService.signupMember(signupRequest).getEmail());
    }

}
