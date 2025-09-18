package com.example.lms.service;


import com.example.lms.dto.ApiResponse;
import com.example.lms.dto.MemberRequest;
import com.example.lms.dto.MemberResponse;
import com.example.lms.exception.ResourceNotFoundException;
import com.example.lms.mapper.MemberMapper;
import com.example.lms.model.users.Member;
import com.example.lms.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public ApiResponse addMember(MemberRequest request) {
        Member member = Member.builder()
                .username(request.getFullName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .address(request.getAddress())
                .build();
        Member saved = memberRepository.save(member);
        return ApiResponse.of("Member created successfully", MemberMapper.toResponse(saved));
    }

    @Override
    public ApiResponse getAllMembers() {
        List<MemberResponse> responses = memberRepository.findAll()
                .stream().map(MemberMapper::toResponse).collect(Collectors.toList());
        if (responses.isEmpty()) {
            return ApiResponse.of("No members found");
        }
        return ApiResponse.of("Members fetched successfully", responses);
    }

    @Override
    public ApiResponse getMemberById(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found"));
        return ApiResponse.of("Member fetched successfully", MemberMapper.toResponse(member));
    }

    @Override
    public ApiResponse updateMember(Long id, MemberRequest request) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found"));

        if (request.getFullName() != null) member.setFullName(request.getFullName());
        if (request.getEmail() != null) member.setEmail(request.getEmail());
        if (request.getPhone() != null) member.setPhone(request.getPhone());
        if (request.getAddress() != null) member.setAddress(request.getAddress());

        Member updated = memberRepository.save(member);
        return ApiResponse.of("Member updated successfully", MemberMapper.toResponse(updated));
    }

    @Override
    public ApiResponse deleteMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found"));
        memberRepository.delete(member);
        return ApiResponse.of("Member deleted successfully");
    }
}
