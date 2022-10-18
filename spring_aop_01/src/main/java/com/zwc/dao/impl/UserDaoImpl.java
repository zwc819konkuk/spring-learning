package com.zwc.dao.impl;

import com.zwc.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public int addUser(int userId, String userName) {
        System.out.println("userDao add......");
        return 1;
    }
}
