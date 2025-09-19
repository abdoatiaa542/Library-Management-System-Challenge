package com.example.lms.service.auth;

import com.example.lms.dto.*;
import com.example.lms.exception.ResourceAlreadyExistsException;
import com.example.lms.model.AccessToken;
import com.example.lms.model.users.User;
import com.example.lms.repository.UserRepository;
import com.example.lms.service.access_token.AccessTokenService;
import com.example.lms.service.jwt.BearerTokenWrapper;
import com.example.lms.utils.ContextHolderUtils;
import io.jsonwebtoken.lang.Strings;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

    private final AccessTokenService accessTokenService;
    private final BearerTokenWrapper bearerTokenWrapper;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;


    @Override
    public Object loginUser(Object object) {
        try {
            LoginRequest request = (LoginRequest) object;
            Authentication authentication = authenticationManager.
                    authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));

            if (Objects.nonNull(authentication) && authentication.isAuthenticated() && authentication.getPrincipal() instanceof User user) {
                AccessToken accessToken = accessTokenService.create(user);
                AccessToken refreshToken = accessTokenService.refresh(user);
                userRepository.save(user);


                String token = accessToken.getToken();
                String refreshTokenValue = refreshToken.getToken();
                String message = "Successful user login.";


                LoginResponse response = new LoginResponse(
                        token,
                        refreshTokenValue
                );

                return ApiResponse.of(message, response);
            } else {
                return ApiResponse.of("Invalid username or password");
            }
        } catch (Exception e) {
            return ApiResponse.of("Error logging in user: " + e.getMessage());
        }
    }

    @Override
    public Object logoutUser(String deviceToken) {
        String bearerToken = bearerTokenWrapper.getToken();
        if (!Strings.hasText(bearerToken)) {
            throw new IllegalArgumentException("Bearer token must not be null or empty");
        }
        accessTokenService.delete(bearerToken);

        if (Strings.hasText(deviceToken)) {
            User currentUser = ContextHolderUtils.getUser();
            userRepository.save(currentUser);
        }

        return ApiResponse.of("User logged out successfully.");
    }

    @Override
    public ApiResponse registerAdmin(RegistrationRequest request) {
        return registerUserWithRole(request, Role.ADMIN);
    }

    @Override
    public ApiResponse registerLibrarian(RegistrationRequest request) {
        return registerUserWithRole(request, Role.LIBRARIAN);
    }

    @Override
    public ApiResponse registerStaff(RegistrationRequest request) {
        return registerUserWithRole(request, Role.STAFF);
    }

    @Override
    public Object registerMember(RegistrationRequest request) {
        return registerUserWithRole(request, Role.MEMBER);
    }


    private ApiResponse registerUserWithRole(RegistrationRequest request, Role role) {
        if (userRepository.existsByEmailIgnoreCase(request.email())) {
            throw new ResourceAlreadyExistsException("User with this email already exists!");
        }

        User user = User.builder()
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .username(request.username())
                .role(role)
                .build();

        userRepository.save(user);
        return ApiResponse.of("User registered successfully as " + role.name());
    }

}
