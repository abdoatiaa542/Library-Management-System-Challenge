package com.example.lms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberRequest {
    private String fullName;
    private String email;
    private String phone;
    private String address;
}