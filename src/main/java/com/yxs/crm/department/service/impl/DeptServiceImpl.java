package com.yxs.crm.department.service.impl;

import com.yxs.crm.department.dao.DeptDao;
import com.yxs.crm.department.service.DeptService;
import com.yxs.crm.staff.domain.Department;
import com.yxs.crm.staff.domain.Post;
import com.yxs.crm.staff.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public class DeptServiceImpl implements DeptService {
    private DeptDao deptDao;

    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
    }

    @Override
    public Department addDept(Department department) {
        return deptDao.addDept(department);
    }

    @Override
    public List<Department> getDept() {
        return deptDao.getDept();
    }

    @Override
    public List<Post> getPostByDeptId(Department department) {
        return deptDao.getPostByDeptId(department);
    }

    @Override
    public List<Staff> getStaffByDeptId(Department department) {
        return deptDao.getStaffByDeptId(department);
    }

    @Override
    public List<Staff> queryStaff(Department department, Post post, Staff staff) {
        return deptDao.queryStaff(department,post,staff);
    }
}
