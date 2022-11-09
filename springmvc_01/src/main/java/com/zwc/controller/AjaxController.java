package com.zwc.controller;

import com.zwc.pojo.Person;
import com.zwc.pojo.Pet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {

    /*
    * @ResponseBody作用
    * 1、方法的返回值不再作为界面跳转的依据，而是直接作为返回的数据
    * 2、可以将方法的返回的数据自动转化【objectMapper】为JSON格式
    * */
    @ResponseBody
    @RequestMapping("testAjax")
    public Pet testAjax(Person p){
        System.out.println(p);
        Pet pet = new Pet("tom", "cat");
        return pet;
    }
}
