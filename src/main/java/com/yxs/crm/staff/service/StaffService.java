package com.yxs.crm.staff.service;

import com.yxs.crm.staff.domain.Department;
import com.yxs.crm.staff.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public interface StaffService {

    Staff login(Staff staff);
    Staff addStaff(Staff staff);
    List<Staff> getStaff();
//    List<Department> getDeptList_Staff();
}
