package com.zwc.service.impl;

import com.zwc.dao.UserDao;
import com.zwc.dao.impl.UserDaoImplA;
import com.zwc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
//    @Autowired
//    @Qualifier("userDaoImplB")
//    @Qualifier("userDaoImplA")
//    private UserDao userDao;

//    @Resource(name = "userDaoImplA")
    @Resource(name = "userDaoImplB")
    private UserDao userDao;

    /*
        普通数据类型
     */
    @Value("${sName}")
    private String sName;
    @Value("${sGender}")
    private String sGender;
    @Value("${sAge}")
    private Integer sAge;

    public void add() {
        System.out.println("userServiceImpl add...");
        System.out.println(sName);
        System.out.println(sAge);
        System.out.println(sGender);
        userDao.add();
    }
}
