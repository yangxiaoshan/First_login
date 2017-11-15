package com.yxs.crm.department.dao.impl;

import com.yxs.crm.department.dao.DeptDao;
import com.yxs.crm.staff.domain.Department;
import com.yxs.crm.staff.domain.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class DeptDaoImplTest {
    @Resource
    private DeptDao deptDao;
    @Test
    public void test(){
        Department d = new Department(1);
        List<Post> postList = deptDao.getPostByDeptId(d);
        for (Post post : postList) {
            System.out.println(post.getPostName());
        }
    }
}