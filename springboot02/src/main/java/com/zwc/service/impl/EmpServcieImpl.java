package com.zwc.service.impl;

import com.zwc.mapper.EmpMapper;
import com.zwc.pojo.Emp;
import com.zwc.pojo.User;
import com.zwc.service.EmpService;
import com.zwc.service.UserService;
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
}
