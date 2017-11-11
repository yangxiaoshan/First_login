package com.yxs.crm.staff.dao;

import com.yxs.crm.staff.domain.Staff;

/**
 * Created by dllo on 17/11/10.
 */
public interface StaffDao {
    Staff login(Staff staff);

    Staff addStaff(Staff staff);
}
