package com.itlize.springsecurityjwt.service;

import com.itlize.springsecurityjwt.DAO.UserDao;
import com.itlize.springsecurityjwt.models.AuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthenticationRequest newUserDetail = userDao.findByUsername(username);
        return new User(newUserDetail.getUsername(),passwordEncoder.encode(newUserDetail.getPassword()), new ArrayList<>());
    }

}

