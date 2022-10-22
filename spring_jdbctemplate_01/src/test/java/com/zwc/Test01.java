package com.zwc;

import com.zwc.pojo.Emp;
import com.zwc.service.EmpService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    @Test
    public void testEmpService(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmpService empService = context.getBean(EmpService.class);
//        int empCount = empService.findEmpCount();
//        System.out.println(empCount);
        Emp emp = empService.findByEmpno(7521);
        System.out.println(emp);
    }
}
