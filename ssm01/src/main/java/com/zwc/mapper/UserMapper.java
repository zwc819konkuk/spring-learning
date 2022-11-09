package com.zwc.mapper;

import com.zwc.pojo.User;

import java.util.List;

public interface UserMapper {
    User findUser(String uname, String password);

    List<User> findAllUser();
}
