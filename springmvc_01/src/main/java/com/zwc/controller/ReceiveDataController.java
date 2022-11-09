package com.zwc.controller;

import com.zwc.pojo.Person;
import com.zwc.pojo.Pet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ReceiveDataController {

    /**
     * 通过使用pojo接收对象
     * 提交的参数名必须和POJO的属性名保持一致
     * 因为底层用的是反射【用的是set方法给参数列表赋值】
     *
     * @param p
     * @return
     */
    @RequestMapping("/getDataByPojo")
    public String getDataByPojo(Person p) {
        System.out.println(p);
        return "success";
    }
}
