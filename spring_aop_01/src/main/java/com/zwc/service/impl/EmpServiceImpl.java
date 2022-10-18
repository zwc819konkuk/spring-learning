package com.zwc.service.impl;

import com.zwc.dao.EmpDao;
import com.zwc.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public int addEmp(int empno, String ename, String job) {
        System.out.println("empService add......");
        return 1;
    }
}
