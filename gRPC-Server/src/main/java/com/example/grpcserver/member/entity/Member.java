package com.example.grpcserver.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @Comment("회원 아이디")
    @GeneratedValue(strategy = GenerationType.AUTO)  // UUID 전략 설정
    private Long id;  // UUID 타입

    @Comment("이메일")
    @Column(nullable = false)
    private String email;

    @Comment("패스워드")
    @Column(nullable = false)
    private String password;

    @Comment("이름")
    @Column(nullable = false)
    private String name;

}
