package com.yxs.crm.staff.service.impl;

import com.yxs.crm.staff.dao.StaffDao;
import com.yxs.crm.staff.domain.Department;
import com.yxs.crm.staff.domain.Staff;
import com.yxs.crm.staff.service.StaffService;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public class StaffServiceImpl implements StaffService {

    private StaffDao staffDao;

    @Override
    public Staff login(Staff staff) {
        return staffDao.login(staff);
    }

    @Override
    public Staff addStaff(Staff staff) {
        return staffDao.addStaff(staff);
    }

    @Override
    public List<Staff> getStaff() {
        return staffDao.getStaff();
    }

    @Override
    public List<Department> getDept() {
        return staffDao.getDept();
    }


    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
