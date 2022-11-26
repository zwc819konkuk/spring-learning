package com.zwc.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zwc.mapper.EmpMapper;
import com.zwc.pojo.Emp;
import com.zwc.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpServcieImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;


    @Override
    public List<Emp> findAll() {
        return empMapper.findAll();
    }

    @Override
    public boolean removeEmp(Integer empno, String ename) {
        return empMapper.removeEmp(empno,ename)>0;
    }


}
