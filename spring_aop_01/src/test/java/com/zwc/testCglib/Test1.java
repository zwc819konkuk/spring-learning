package com.zwc.testCglib;


import lombok.Data;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Test1 {

    /**
     * cglib动态代理
     */
    @Test
    public void testCglib() {
        Person person = new Person();

        //获取person的代理对象
        //1、获得一个Enhancer对象
        Enhancer enhancer = new Enhancer();
        //2、设置父类的字节码
        enhancer.setSuperclass(Person.class);
        //3、设置methodInterceptor对象 用于定义增强规则
        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                /*
                   Object o, 生成之后的代理对象personProxy
                   Method method, 父类中原本要执行的方法，Person中的eat()
                   Object[] objects, 方法在调用时的实参数组
                   MethodProxy methodProxy, 子类中重写父类的方法 personProxy中的eat()
                 */
                Object res = null;
                if (method.getName().equals("eat")) {
                    System.out.println("washing hands");
                    res = methodProxy.invokeSuper(o, objects);
                    System.out.println("cleaning table");
                } else {
                    res = methodProxy.invokeSuper(o, objects);//子类对象方法在执行，默认调用父类对应被重写的方法
                }
                return res;
            }
        };
        //4、设置MethodInterceptor
        enhancer.setCallback(methodInterceptor);
        //5、获得代理对象
        Person personProxy = (Person) enhancer.create();
        //6、使用代理对象完成功能
        personProxy.eat("包子");
    }
}

@Data
class Person {


    public Person() {

    }


    public void eat(String foodName) {
        System.out.println("正在吃:" + foodName);
    }

    public void drink() {
        System.out.println("正在喝茶");
    }
}


