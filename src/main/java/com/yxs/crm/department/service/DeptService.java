package com.yxs.crm.department.service;

import com.yxs.crm.staff.domain.Department;
import com.yxs.crm.staff.domain.Post;
import com.yxs.crm.staff.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public interface DeptService {
    Department addDept(Department department);
    List<Department> getDept();
    List<Post> getPostByDeptId(Department department);
    List<Staff> getStaffByDeptId(Department department);
    List<Staff> queryStaff(Department department,Post post,Staff staff);
}
