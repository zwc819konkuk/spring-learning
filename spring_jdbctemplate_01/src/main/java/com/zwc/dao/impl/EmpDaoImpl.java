package com.zwc.dao.impl;

import com.zwc.dao.EmpDao;
import com.zwc.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDaoImpl implements EmpDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int findEmpCount() {
        String sql = "select count(1) from emp";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    public Emp findByEmpno(int empno) {
        String sql = "select * from emp where empno=?";
        BeanPropertyRowMapper<Emp> rowMapper = new BeanPropertyRowMapper<Emp>(Emp.class);

        Emp emp = jdbcTemplate.queryForObject(sql, rowMapper, empno);
        return emp;
    }
}
