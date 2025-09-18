package com.example.lms.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberResponse {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String address;
}