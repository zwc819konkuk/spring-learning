package com.zwc;

public class Test01 {
    public static void main(String[] args) {
        Person person = new Person("zhangsan");
        Court court = new Lawyer(person);
        court.doCourt();
    }
}


interface Court{
    void doCourt();
}
//代理类
class Lawyer implements Court{
    private Person person;

    public Lawyer(Person person) {
        this.person = person;
    }

    public void doCourt() {
        System.out.println("律师取证，zhangsan不咋案发现场");
        System.out.println("律师总结:zhangsan不可能杀人");
        person.doCourt();
    }
}
//被代理的类
class Person implements Court{

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void doCourt() {
        System.out.println(name+"说:我没罪");
    }
}