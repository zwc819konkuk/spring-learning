package com.zwc.testProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK的动态代理【proxy】
 */
public class Test1 {
    public static void main(String[] args) {
        final Dinner dinner = new Student("张三");

        //通过proxy动态代理获得代理对象,在代理对象中，对某个方法进行增强
        Dinner dinnerProxy = (Dinner) Proxy.newProxyInstance(
                Person.class.getClassLoader(),
                Person.class.getInterfaces(),
                new InvocationHandler() {
                    //当我们让代理对象调用任何方法时，触发invoke方法，在此方法中定义增强的逻辑
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object res = null;
                        if (method.getName().equals("eat")) {
                            System.out.println("washing hands");

                            //让原来的方法运行
                            res = method.invoke(dinner, args);

                            System.out.println("cleaning table");
                        } else {
                            res = method.invoke(dinner, args);
                        }
                        return res;
                    }
                });


        dinnerProxy.eat("包子");
        dinnerProxy.drink();
    }
}

interface Dinner {
    void eat(String foodName);

    void drink();
}

//person没办法修改的情况下
class Person implements Dinner {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void eat(String foodName) {
        System.out.println(name + "正在吃:" + foodName);
    }

    @Override
    public void drink() {
        System.out.println(name + "正在喝茶");
    }
}

class Student implements Dinner {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void eat(String foodName) {
        System.out.println(name + "正在食堂吃:" + foodName);
    }

    @Override
    public void drink() {
        System.out.println(name + "正在食堂喝水");
    }
}
