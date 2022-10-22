package com.zwc.dao.impl;

import com.zwc.dao.DeptDao;
import com.zwc.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeptDaoImpl implements DeptDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int[] deptBatchAdd(List<Dept> depts) {

        String sql = "insert into dept values(DEFAULT,?,?)";
        List<Object[]> args = new ArrayList<Object[]>();
        for (Dept dept : depts) {
            Object[] arg  = {dept.getDname(),dept.getLoc()};
            args.add(arg);
        }
        int[] rows = jdbcTemplate.batchUpdate(sql, args);

        return rows;
    }
}
