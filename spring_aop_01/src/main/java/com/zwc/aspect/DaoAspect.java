package com.zwc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class DaoAspect {
    //定义一个公共切点 切点表达式直接指向接口 降低耦合度
    @Pointcut("execution(* com.zwc.dao.*.add*(..))")
    public void addPointCut() {
    }

    @Before("addPointCut()")
    public void methodBefore(JoinPoint joinPoint) {
        System.out.println("method before invoked...");
        Object[] args = joinPoint.getArgs();
        System.out.println("args:" + Arrays.toString(args));
    }

    /**
     * 无论切点是否出现异常 都会执行
     * 后置也叫最终通知
     */
    @After("addPointCut()")
    public void methodAfter() {
        System.out.println("methodAfter invoked...");
    }

    /**
     * 返回通知：在切点方法返回结果之后增强的功能
     * 切点方法如果出现异常 则不执行
     *
     * @param joinPoint 切点
     * @param res       切点方法返回值
     */
    @AfterReturning(value = "addPointCut()", returning = "res")
    public void methodAfterReturning(JoinPoint joinPoint, Object res) {
        System.out.println("methodAfterReturning invoked...");
        System.out.println(res);
    }

    /**
     * 异常通知：切点方法出现异常时执行
     * 可以接受异常对象
     */
    @AfterThrowing(value = "addPointCut()", throwing = "ex")
    public void methodAfterThrowing(Exception ex) {
        System.out.println("methodAfterThrowing invoked...");
        System.out.println(ex.getMessage());
    }


    /**
     * 环绕通知：在切点方法之前和之后执行
     * 环绕通知的返回值必须是object 将切点方法继续向上返回
     *
     * @param proceedingJoinPoint 切点,手动控制切点方法执行的位置
     */
    @Around("addPointCut()")
    public Object methodAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("methodAroundA invoked...");
        Object res = proceedingJoinPoint.proceed();
        System.out.println("methodAroundB invoked...");
        return res;
    }
}
