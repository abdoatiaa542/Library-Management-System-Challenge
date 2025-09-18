package com.example.lms.service.auth;

import com.example.lms.dto.RegistrationRequest;
import org.springframework.lang.Nullable;


public interface IAuthService {

    Object loginUser(Object object);

    Object logoutUser(@Nullable String deviceToken);

    Object registerAdmin(RegistrationRequest request);

    Object registerLibrarian(RegistrationRequest request);

    Object registerStaff(RegistrationRequest request);

    Object registerMember(RegistrationRequest request);

}
