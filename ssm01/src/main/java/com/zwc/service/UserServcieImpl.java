package com.zwc.service;

import com.zwc.mapper.UserMapper;
import com.zwc.pojo.User;
import com.zwc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServcieImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUser(String uname, String password) {
        return userMapper.findUser(uname, password);
    }

    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }
}
