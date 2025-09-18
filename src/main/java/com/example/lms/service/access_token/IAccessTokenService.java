package com.example.lms.service.access_token;

import com.example.lms.model.AccessToken;
import com.example.lms.model.users.User;

public interface IAccessTokenService {
    AccessToken create(User user);

    AccessToken get(String token);

    boolean exists(String token);

    void delete(String token);

    AccessToken refresh(User user);
}