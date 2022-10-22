package com.zwc.service;

import com.zwc.pojo.Emp;

public interface EmpService {
    /**
     * 查询员工个数
     */
    int findEmpCount();

    Emp findByEmpno(int empno);
}
