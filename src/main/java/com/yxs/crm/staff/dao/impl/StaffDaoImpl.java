package com.yxs.crm.staff.dao.impl;

import com.yxs.crm.staff.dao.StaffDao;
import com.yxs.crm.staff.domain.Staff;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao{
    @Override
    public Staff login(Staff staff) {

        List<Staff> staffs = getHibernateTemplate().findByExample(staff);
        if (staffs !=null && staffs.size() > 0){
            return staffs.get(0);
        }
        return null;
    }
}
