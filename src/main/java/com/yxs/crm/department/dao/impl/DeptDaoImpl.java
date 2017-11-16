package com.yxs.crm.department.dao.impl;

import com.yxs.crm.department.dao.DeptDao;
import com.yxs.crm.staff.domain.Department;
import com.yxs.crm.staff.domain.Post;
import com.yxs.crm.staff.domain.Staff;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public class DeptDaoImpl extends HibernateDaoSupport implements DeptDao {

    private List<Staff> staffList;

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

    @Override
    public List<Staff> getStaffByDeptId(Department department) {
        String sql = "from Staff T_STAFF where department.deptID=?";
        List<Staff> staffList = (List<Staff>) getHibernateTemplate().find(sql, department.getDeptID());
        return staffList;
    }

    @Override
    public List<Staff> queryStaff(Department department, Post post, Staff staff) {
        if (department != null && post == null && staff.getStaffName() == null) {
            String sql = "from Staff T_STAFF where department.deptID=?";
            staffList = (List<Staff>) getHibernateTemplate().find(sql, department.getDeptID());
            return staffList;
        } else if (department != null && post != null && staff.getStaffName() == null) {
            String sql = "from Staff T_STAFF where department.deptID=? and post.postID=?";
            staffList = (List<Staff>) getHibernateTemplate().find(sql, department.getDeptID(), post.getPostID());
            return staffList;
        } else if (department != null && post != null && staff.getStaffName() != null) {
            String sql = "from Staff T_STAFF where department.deptID=? and post.postID=? and staffName like ?";
            staffList = (List<Staff>) getHibernateTemplate().find(sql, department.getDeptID(), post.getPostID(), "'%" + staff + "%'");
            return staffList;
        } else if (department == null&&post==null&& staff.getStaffName() != null) {
            String sql = "from Staff T_STAFF where staffName like ?";
            staffList = (List<Staff>) getHibernateTemplate().find(sql, "'%" + staff + "%'");
            return staffList;
        } else {
            staffList = getHibernateTemplate().loadAll(Staff.class);
            return staffList;
        }
    }

}
