package com.zwc.controller;

import com.zwc.pojo.User;
import com.zwc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ScopeController {

    @Autowired
    private UserService userService;

    /*
    * 定义一个处理单元，向三个域中放入数据
    * */
    @RequestMapping("setData")
    public String setData(HttpServletRequest req,HttpSession session ){
        List<User> users = userService.findAllUser();
        //向三个域中放入数据
        //request:只有访问当前controller提供路径时才能访问到
        req.setAttribute("msg","reqMsg");
        req.setAttribute("users",users);

        //关闭浏览器后，相当于清掉了cookie，，然后打开浏览器相当于再次开启了一个新的对话，再次访问这个资源的时候，访问不到
        session.setAttribute("msg","sessionMsg");
        session.setAttribute("users",users);

        ServletContext application = req.getServletContext();
        application.setAttribute("msg","applicationMsg");
        application.setAttribute("users",users);
        //跳转至页面
        return "/showDataPage.jsp";
    }
}
