package com.zwc.service;

import com.zwc.pojo.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> findAll();

    boolean removeEmp(Integer empno, String ename);
}
