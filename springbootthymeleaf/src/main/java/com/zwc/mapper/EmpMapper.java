package com.zwc.mapper;

import com.zwc.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {
    List<Emp> findAll();

    int removeEmp(Integer empno, String ename);
}
