package com.yxs.crm.staff.dao;

import com.yxs.crm.staff.domain.Department;
import com.yxs.crm.staff.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public interface StaffDao {
    Staff login(Staff staff);

    Staff addStaff(Staff staff);

    List<Staff> getStaff();
    List<Department> getDept();
}
