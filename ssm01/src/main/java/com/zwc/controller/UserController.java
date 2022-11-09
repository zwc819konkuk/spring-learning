package com.zwc.controller;

import com.zwc.pojo.User;
import com.zwc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("login.do")
    public String login(String uname,String password){
        String view = "";
        User user = userService.findUser(uname,password);
        if (null != user){
            view = "/success.jsp";
        }else {
            view = "/fail.jsp";
        }
        return view;
    }
}
