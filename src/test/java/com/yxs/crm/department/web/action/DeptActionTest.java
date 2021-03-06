package com.yxs.crm.department.web.action;

import com.yxs.crm.department.service.DeptService;
import com.yxs.crm.staff.domain.Department;
import com.yxs.crm.staff.domain.Post;
import com.yxs.crm.staff.domain.Staff;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class DeptActionTest {
    @Resource
    private DeptService service;
    @Test
    public void test(){
        Department d = new Department(10,"测试部");
        service.addDept(d);
    }
}