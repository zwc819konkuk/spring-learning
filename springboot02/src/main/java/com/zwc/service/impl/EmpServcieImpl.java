package com.zwc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @Override
    public List<Emp> findByPage(Integer pageNum, Integer pageSize) {

        Page<Emp> page = PageHelper.startPage(pageNum, pageSize);
        List<Emp> list = empMapper.findAll();
        // 方式1 不推荐
        System.out.println("当前页:"+page.getPageNum());
        System.out.println("总页数"+page.getPages());
        System.out.println("页大小:"+page.getPageSize());
        System.out.println("总记录数:"+page.getTotal());
        System.out.println("当前页数据"+page.getResult());
        // 方式2 有关于page的更多信息
        PageInfo<Emp> pi =new PageInfo<>(list);
        System.out.println("当前页"+pi.getPageNum());
        System.out.println("总页数"+pi.getPages());
        System.out.println("页大小"+pi.getSize());
        System.out.println("总记录数"+pi.getTotal());
        System.out.println("当前页数据"+pi.getList());

        return list;
    }
}
