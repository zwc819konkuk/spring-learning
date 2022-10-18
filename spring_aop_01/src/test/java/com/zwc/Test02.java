package com.zwc;

import com.zwc.config.SpringConfig;
import com.zwc.dao.EmpDao;
import com.zwc.dao.UserDao;
import com.zwc.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {

    @Test
    public void testBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao dao = context.getBean(UserDao.class);
        int rows = dao.addUser(1, "jack");
        System.out.println(rows);

//        System.out.println("==========================");
//
//        EmpDao empDao = context.getBean(EmpDao.class);
//        int rows1 = empDao.addEmp(1, "jack", "ceo");
//        System.out.println(rows1);
    }

    @Test
    public void testBean2() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserDao dao = context.getBean(UserDao.class);
        int rows = dao.addUser(1, "jack");
        System.out.println(rows);
    }
}
