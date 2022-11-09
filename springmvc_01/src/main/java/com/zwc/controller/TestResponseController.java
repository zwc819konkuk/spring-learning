package com.zwc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class TestResponseController {

    @RequestMapping("testVoid")
    public void testVoid() {
        System.out.println("void controller");
    }

    /*
     * 原始的servlet方式 耦合度较高
     * */
    @RequestMapping("demo1")
    public void testDemo1(HttpServletRequest request, HttpServletResponse resp) throws Exception {
        //请求转发
        //request.getRequestDispatcher("/forwardPage.jsp").forward(request,resp);
        //响应重定向[上下文路径+资源名]
        resp.sendRedirect(request.getContextPath() + "/redirectPage.jsp");
    }

    /*
     * 松耦合方式
     * 通过返回字符串  告诉dispatchServlet要跳转的路径 请求转发
     * 使用forward关键字，可以省略不写
     * */
    @RequestMapping("demo2")
    public String testDemo2() {
        return "forward:/forwardPage.jsp";
    }

    /*
     * 松耦合方式
     * 通过返回字符串  告诉dispatchServlet要跳转的路径 重定向
     * 使用redirect关键字，不可以省略不写
     * / 表示当前项目下，这里不需要项目的上下文路径
     * */
    @RequestMapping("demo3")
    public String testDemo3() {
        return "redirect:/redirectPage.jsp";
    }

    /*
     * 松耦合方式
     * 通过返回字符串  告诉dispatchServlet要跳转的路径 重定向
     * 使用redirect关键字，不可以省略不写
     * / 表示当前项目下，这里不需要项目的上下文路径
     * */
    @RequestMapping("demo4")
    public View testDemo4(HttpServletRequest request) {
        View view = null;
        //请求转发
//        view = new InternalResourceView("/forwardPage.jsp");
        //重定向
        view = new RedirectView(request.getContextPath() + "/redirectPage.jsp");
        return view;
    }

    @RequestMapping("demo5")
    public ModelAndView testDemo5(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        //请求转发
        mv.setViewName("forward:/forwardPage.jsp");
        //响应重定向
        mv.setViewName("redirect:/redirectPage.jsp");
        return mv;
    }
}
