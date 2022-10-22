package com.zwc.service;

import com.zwc.pojo.Dept;

import java.util.List;

public interface DeptService {
    int[] deptBatchAdd(List<Dept> depts);
}
