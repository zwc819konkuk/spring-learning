package com.zwc.controller;

import com.zwc.pojo.User;
import com.zwc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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
        //request:只有访问当前controller提供路径时才能访问到【只是在请求转发forward中有效】
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


    /*
    * Model对象的setAttribute
    * 主要是对请求域传递数据进行了API的封装
    * 降低controller和servlet之间的耦合度
    * 重定向下，没法使用model传递域中的数据
    * model中的字符串类型的键值对信息会转化为请求参数【"msg","reqMsg"】，转发给目标组件
    * */
    @RequestMapping("setData2")
    public String setData2(Model model){

        List<User> users = userService.findAllUser();

        //向三个域中放入数据
        //request:只有访问当前controller提供路径时才能访问到
        model.addAttribute("msg","reqMsg");
        model.addAttribute("users",users);


        //跳转至页面forward
        return "redirect:/showDataPage.jsp";
    }

    /**
     *主要是对请求域传递数据进行了API的封装
     *降低controller和servlet之间的耦合度
     */
    @RequestMapping("setData3")
    public ModelAndView setData3(){
        List<User> users = userService.findAllUser();

        ModelAndView mv = new ModelAndView();

        Map<String, Object> model = mv.getModel();
        model.put("msg","reqMsg");
        model.put("users",users);

        mv.setViewName("redirect:showDataPage.jsp");

        return mv;
    }
}
