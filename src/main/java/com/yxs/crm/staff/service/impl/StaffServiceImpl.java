package com.yxs.crm.staff.service.impl;

import com.yxs.crm.staff.dao.StaffDao;
import com.yxs.crm.staff.domain.Staff;
import com.yxs.crm.staff.service.StaffService;

/**
 * Created by dllo on 17/11/10.
 */
public class StaffServiceImpl implements StaffService {

    private StaffDao staffDao;

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    @Override
    public Staff login(Staff staff) {
        return staffDao.login(staff);
    }
}
