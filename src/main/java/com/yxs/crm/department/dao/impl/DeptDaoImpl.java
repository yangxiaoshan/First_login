package com.yxs.crm.department.dao.impl;

import com.yxs.crm.department.dao.DeptDao;
import com.yxs.crm.staff.domain.Department;
import com.yxs.crm.staff.domain.Post;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public class DeptDaoImpl extends HibernateDaoSupport implements DeptDao {

    @Override
    public Department addDept(Department department) {
        if (department != null && department.getDeptID() == 0) {
            getHibernateTemplate().save(department);
        } else {
            getHibernateTemplate().saveOrUpdate(department);
        }
        return department;
    }

    @Override
    public List<Department> getDept() {
        String sql = "from Department T_DEPT";
        return (List<Department>) getHibernateTemplate().find(sql);
    }

    @Override
    public List<Post> getPostByDeptId(Department department) {
        String sql = "from Post T_POST where department.deptID=?";
        List<Post> postList = (List<Post>) getHibernateTemplate().find(sql, department.getDeptID());
        return postList;
    }

}
