package com.yxs.crm.department.service.impl;

import com.yxs.crm.department.dao.DeptDao;
import com.yxs.crm.department.service.DeptService;
import com.yxs.crm.staff.domain.Department;

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
}
