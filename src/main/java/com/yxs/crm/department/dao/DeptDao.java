package com.yxs.crm.department.dao;

import com.yxs.crm.staff.domain.Department;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public interface DeptDao {
    Department addDept(Department department);
    List<Department> getDept();
}
