package com.zwc.service;

import com.zwc.dao.AccountDao;
import com.zwc.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Transactional
    public int transMoney(int from, int to, int money) {
        int rows = 0;
        //转出操作
        rows += accountDao.transMoney(from, 0 - money);

        //装入操作
        rows += accountDao.transMoney(to, money);
        return rows;
    }
}
