package com.zwc;

import com.zwc.pojo.Dept;
import com.zwc.pojo.Emp;
import com.zwc.service.DeptService;
import com.zwc.service.EmpService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Test01 {

    @Test
    public void testEmpService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmpService empService = context.getBean(EmpService.class);
//        int empCount = empService.findEmpCount();
//        System.out.println(empCount);
        Emp emp = empService.findByEmpno(7521);
        System.out.println(emp);
    }

    @Test
    public void testBatchDeptService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DeptService deptService = context.getBean(DeptService.class);
        List<Dept> depts = new ArrayList<Dept>();
        for (int i = 0; i < 10; i++) {
            depts.add(new Dept(null, "name" + i, "loc" + i));
        }
        System.out.println(deptService.deptBatchAdd(depts));
    }
}
