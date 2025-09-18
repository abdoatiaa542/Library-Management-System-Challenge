package com.example.lms.dto;

import com.example.lms.annotation.UserUnique;
import com.example.lms.annotation.UserUniqueConstraint;
import com.example.lms.constant.RegexConstants;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RegistrationRequest(


        @Email
        @NotBlank
        @UserUnique(constraint = UserUniqueConstraint.EMAIL)
        String email,
        @NotBlank
        @UserUnique(constraint = UserUniqueConstraint.USERNAME)
        String username,
        @NotBlank
        @Pattern(regexp = RegexConstants.PASSWORD)
        String password
) {

}
