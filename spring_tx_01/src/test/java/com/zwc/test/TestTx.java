package com.zwc.test;

import com.zwc.conf.SpringConfig;
import com.zwc.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.TreeMap;

public class TestTx {

    @Test
    public void testTransMoney(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService service = context.getBean(AccountService.class);
        int rows = service.transMoney(1, 2, 100);
        System.out.println(rows);

    }
    @Test
    public void testTransMoney1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService service = context.getBean(AccountService.class);
        int rows = service.transMoney(1, 2, 100);
        System.out.println(rows);

    }
}
