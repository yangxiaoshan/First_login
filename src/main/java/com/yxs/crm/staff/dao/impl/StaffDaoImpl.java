package com.yxs.crm.staff.dao.impl;

import com.yxs.crm.staff.dao.StaffDao;
import com.yxs.crm.staff.domain.Department;
import com.yxs.crm.staff.domain.Staff;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
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

    @Override
    public Staff addStaff(Staff staff) {
        getHibernateTemplate().saveOrUpdate(staff);
        return staff;
    }

    @Override
    public List<Staff> getStaff() {
        String sql = "from Staff T_STAFF";
        return (List<Staff>) getHibernateTemplate().find(sql);
    }

    @Override
    public List<Department> getDept() {
        String sql = "from Department T_DEPT";
        return (List<Department>) getHibernateTemplate().find(sql);
    }


}
