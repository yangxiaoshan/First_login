package com.yxs.crm.department.web.action;

import com.yxs.crm.base.BaseAction;
import com.yxs.crm.department.service.DeptService;
import com.yxs.crm.staff.domain.Department;
import com.yxs.crm.staff.domain.Post;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public class DeptAction extends BaseAction<Department, DeptService> {

    private List<Department> departments;
    private List<Post> postList;

    public String addDept() {
        Department department = service.addDept(getModel());
        if (department != null) {
            return SUCCESS;
        }
        return INPUT;
    }

    public String getDept() {
        departments = service.getDept();
        return SUCCESS;
    }

    public String getPostByDeptId() {
        postList = service.getPostByDeptId(getModel());
        return SUCCESS;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }
}
