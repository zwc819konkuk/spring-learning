package com.zwc;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwc.pojo.Dept;
import com.zwc.service.DeptService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisplusApplicationTests {

    @Autowired
    DeptService deptService;

    @Test
    void testFindAll() {
        List<Dept> list = deptService.list();
        for (Dept dept : list) {
            System.out.println(dept);
        }
    }

    //查询多个
    @Test
    void testQueryWrapper() {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("dname", "A");
        List<Dept> list = deptService.list(queryWrapper);
        for (Dept dept : list) {
            System.out.println(dept);
        }
    }

    //查询单个
    @Test
    void testQueryWrapper2() {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("deptno", 20);
        Dept dept = deptService.getOne(queryWrapper);
        System.out.println(dept);
    }

    @Test
    void testAdd() {
        boolean save = deptService.save(new Dept(null, null, "aa", "bb"));
        System.out.println(save);
    }

    //修改
    @Test
    void testUpdate() {
        Dept dept = new Dept();
        dept.setDname("xx");
        dept.setLoc("yy");
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("deptno", 41);
        boolean update = deptService.update(dept, queryWrapper);
        System.out.println(update);
    }

    //delete
    @Test
    void testDelete() {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("deptno", 41);
        boolean remove = deptService.remove(queryWrapper);
        System.out.println(remove);
    }

    //测试分页
    @Test
    void testPage() {
        //当前页 页大小
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        Page<Dept> page = deptService.page(new Page<>(1, 2), queryWrapper);
        //当前页数据 总页数 总记录数 当前页 页大小
        List<Dept> records = page.getRecords();
        records.forEach(System.out::println);
        System.out.println("total page" + page.getPages());
        System.out.println("total records" + page.getTotal());
        System.out.println("cur page" + page.getCurrent());
        System.out.println("page size" + page.getSize());
    }
}
