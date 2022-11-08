package com.zwc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

    /**
     * 返回值定义为String用来表明要跳转的页面的路径
     *
     * @return
     */
    @RequestMapping("fc")
    public String firstController() {
        return "first";
    }

    @RequestMapping(value = "test",method = {RequestMethod.GET,RequestMethod.POST})
    public String testRequest(){
        return "first";
    }

    @RequestMapping(value = "test2",params = {"username!=root",  "password"})
    public String testRequest2(){
        return "first";
    }
    @RequestMapping(value = "test3",headers = "")
    public String testRequest3(){
        return "first";
    }
}

