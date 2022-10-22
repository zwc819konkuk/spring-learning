package com.zwc.dao;

import com.zwc.pojo.Dept;

import java.util.List;

public interface DeptDao {
    int[] deptBatchAdd(List<Dept> depts);
}
