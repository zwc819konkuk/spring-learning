package com.zwc.service;

import com.zwc.dao.EmpDao;
import com.zwc.pojo.Emp;
import com.zwc.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    public int findEmpCount() {
        return empDao.findEmpCount();
    }

    public Emp findByEmpno(int empno) {
        return empDao.findByEmpno(empno);
    }
}
