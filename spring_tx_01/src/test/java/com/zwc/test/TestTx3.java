package com.zwc.test;

import com.zwc.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@SpringJUnitConfig(locations = "classpath:applicationContext.xml")
public class TestTx3 {

    @Autowired
    private AccountService accountService;

    @Test
    public void testTransMoney1() {
        int rows = accountService.transMoney(1, 2, 100);
        System.out.println(rows);

    }
}
