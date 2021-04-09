package com.itlize.springsecurityjwt.service;

import com.itlize.springsecurityjwt.models.AuthenticationRequest;

public interface UserService {
    AuthenticationRequest create(AuthenticationRequest user);
}
