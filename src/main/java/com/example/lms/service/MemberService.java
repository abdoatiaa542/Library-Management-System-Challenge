package com.example.lms.service;

import com.example.lms.dto.ApiResponse;
import com.example.lms.dto.MemberRequest;

public interface MemberService {
    ApiResponse addMember(MemberRequest request);

    ApiResponse getAllMembers();

    ApiResponse getMemberById(Long id);

    ApiResponse updateMember(Long id, MemberRequest request);

    ApiResponse deleteMember(Long id);
}