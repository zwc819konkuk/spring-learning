package com.zwc.dao.impl;

import com.zwc.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int transMoney(int id, int money) {
        String sql = "update account set money =money+? where id =?";
        int rows = jdbcTemplate.update(sql, money, id);
        return rows;
    }
}
