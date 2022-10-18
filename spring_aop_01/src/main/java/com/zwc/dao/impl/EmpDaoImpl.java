package com.zwc.dao.impl;

import com.zwc.dao.EmpDao;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDaoImpl implements EmpDao {
    @Override
    public int addEmp(int empno, String ename, String job) {
        System.out.println("empDao add......");
        return 1;
    }
}
