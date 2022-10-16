package com.zwc.dao.impl;

import com.zwc.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImplA implements UserDao {
    public void add() {
        System.out.println("userDaoImplA ADD");
    }
}
