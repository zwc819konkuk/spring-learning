package com.zwc.mapper;

import com.zwc.pojo.User;

public interface UserMapper {
    User findUser(String uname, String password);
}
