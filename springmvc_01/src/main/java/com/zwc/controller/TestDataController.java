package com.zwc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TestDataController {

    /*
     * 紧耦合参数注入
     * 使用传统的HttpServletRequest对象获取参数
     * javax.servlet
     * */
    @RequestMapping("/getParamByRequest")
    public String getParam1(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + ":" + password);
        return "getParamSuccess";
    }

    /*
     * 解耦合参数注入
     * 使用SpringMVC框架功能 自动转换参数
     * 处理单元参数列表中的参数名和请求页面中的参数名一样
     * */
    @RequestMapping("/getParamByArgName")
    public String getParam2(String username, String password) {
        System.out.println(username + ":" + password);
        return "getParamSuccess";
    }
}
