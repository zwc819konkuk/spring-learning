package com.zwc.dao;

import com.zwc.pojo.Emp;

public interface EmpDao {
    int findEmpCount();

    /*
    *查询单个员工对象
    * */
    Emp findByEmpno(int empno);
}
