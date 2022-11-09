package com.zwc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathController {

    @RequestMapping("/testPath/{id}/{username}")
    public String testPath(@PathVariable(value = "id") String id, @PathVariable(value = "username")String username){
        System.out.println(id+":"+username);
        return "first";
    }


}
