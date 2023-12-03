package com.example.springbasic.Member;

import jakarta.persistence.*;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "member_name", nullable = false, length = 255)
    private String memberName;

    @Column(name = "social_security_number", nullable = false, length = 14)
    private String socialSecurityNumber;

    @Column(name = "address", length = 500)
    private String address;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "member_id",insertable = false, updatable = false)
    private Member member;


    public Long getMemberId() {
        return null;
    }
}