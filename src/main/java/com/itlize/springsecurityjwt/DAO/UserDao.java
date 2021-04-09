package com.itlize.springsecurityjwt.DAO;

import com.itlize.springsecurityjwt.models.AuthenticationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<AuthenticationRequest, Integer> {
    AuthenticationRequest findByUsername(String user);
}
