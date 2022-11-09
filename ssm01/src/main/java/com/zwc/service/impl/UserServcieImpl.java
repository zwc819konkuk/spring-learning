package com.zwc.service.impl;

import com.zwc.mapper.UserMapper;
import com.zwc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServcieImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
}
