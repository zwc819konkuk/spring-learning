package com.zwc.service.impl;

import com.zwc.dao.DeptDao;
import com.zwc.pojo.Dept;
import com.zwc.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    public int[] deptBatchAdd(List<Dept> depts) {
        return deptDao.deptBatchAdd(depts);
    }
}
