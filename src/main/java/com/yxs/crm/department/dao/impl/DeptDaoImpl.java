package com.yxs.crm.department.dao.impl;

import com.yxs.crm.department.dao.DeptDao;
import com.yxs.crm.staff.domain.Department;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public class DeptDaoImpl extends HibernateDaoSupport implements DeptDao{

    @Override
    public Department addDept(Department department) {
        getHibernateTemplate().save(department);
        return department;
    }

    @Override
    public List<Department> getDept() {
        String sql = "from Department T_DEPT";
        return (List<Department>) getHibernateTemplate().find(sql);
    }
}
