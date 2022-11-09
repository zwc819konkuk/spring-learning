package com.zwc;

import com.zwc.pojo.User;
import com.zwc.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:applicationContext.xml")
public class TestFindUser {

    @Autowired
    private UserService userService;

    @Test
    public void test01(){
        User user = userService.findUser("zhangsan", "123456");
        System.out.println(user);
    }
}
