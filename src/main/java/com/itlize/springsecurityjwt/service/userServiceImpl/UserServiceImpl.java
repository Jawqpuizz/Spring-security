package com.itlize.springsecurityjwt.service.userServiceImpl;

import com.itlize.springsecurityjwt.DAO.UserDao;
import com.itlize.springsecurityjwt.models.AuthenticationRequest;
import com.itlize.springsecurityjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public AuthenticationRequest create(AuthenticationRequest user) {
        AuthenticationRequest newUser = new AuthenticationRequest();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        return userDao.save(newUser);
    }
}
