package com.zwc.controller;

import com.zwc.pojo.Emp;
import com.zwc.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class ThymeleafController {

    @Autowired
    private EmpService empService;

    @RequestMapping("showAllEmp")
    public String showEmp(Map<String,Object> map){
        List<Emp> empList = empService.findAll();
        map.put("empList",empList);
        map.put("emp",empList.get(0));
        int i = 1/0;
        return "showEmp";
    }
    @RequestMapping("/removeEmp")
    public String removeEmp(Integer empno,String ename){
        boolean success =empService.removeEmp(empno,ename);

        return "redirect:showAllEmp";
    }

    @RequestMapping("showIndex")
    public String showIndex(Map<String,Object> map){
        map.put("msg","testMsg");
        return "index";
    }
}
