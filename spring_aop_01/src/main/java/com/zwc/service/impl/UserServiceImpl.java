package com.zwc.service.impl;

import com.zwc.dao.UserDao;
import com.zwc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(int UserId, String userName) {
        System.out.println("userService addUser...... ");
        int rows = userDao.addUser(UserId, userName);
        return 1;
    }
}
