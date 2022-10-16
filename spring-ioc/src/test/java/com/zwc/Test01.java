package com.zwc;

import com.zwc.bean.Emp;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
}
