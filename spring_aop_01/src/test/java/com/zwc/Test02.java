package com.zwc;

import com.zwc.dao.UserDao;
import com.zwc.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {

    @Test
    public void testBean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao dao = context.getBean(UserDao.class);
        dao.addUser(1,"jack");
    }
}
