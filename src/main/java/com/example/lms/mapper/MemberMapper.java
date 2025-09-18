package com.example.lms.mapper;

import com.example.lms.dto.MemberResponse;
import com.example.lms.model.users.Member;

public class MemberMapper {
    public static MemberResponse toResponse(Member member) {
        return MemberResponse.builder()
                .id(member.getId())
                .fullName(member.getFullName())
                .email(member.getEmail())
                .phone(member.getPhone())
                .address(member.getAddress())
                .build();
    }
}