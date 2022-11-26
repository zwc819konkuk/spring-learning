package com.zwc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwc.mapper.DeptMapper;
import com.zwc.pojo.Dept;
import com.zwc.service.DeptService;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {
}
