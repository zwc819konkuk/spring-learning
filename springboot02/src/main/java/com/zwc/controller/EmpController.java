package com.zwc.controller;

import com.zwc.pojo.Emp;
import com.zwc.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @ResponseBody
    @RequestMapping("findAll")
    public List<Emp> findAll(){

        return empService.findAll();
    }
}
