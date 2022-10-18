package com.zwc.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DaoAspect {
    @Before("execution(* com.zwc.dao.impl.UserDaoImpl.addUser(..))")
    public void methodBefore(){
        System.out.println("method before invoked...");
    }
}
