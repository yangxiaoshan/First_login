package com.yxs.crm.staff.web.action;

import com.yxs.crm.base.BaseAction;
import com.yxs.crm.department.service.DeptService;
import com.yxs.crm.staff.domain.Department;
import com.yxs.crm.staff.domain.Post;
import com.yxs.crm.staff.domain.Staff;
import com.yxs.crm.staff.service.StaffService;
import org.apache.struts2.interceptor.validation.SkipValidation;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public class StaffAction extends BaseAction<Staff,StaffService>{

    private List<Staff> staffs;
    private List<Department> deptList;
    private DeptService deptService;
    private List<Post> postList;

    public String login(){

        Staff staff = service.login(getModel());
        if (staff != null) {
            sessionPut("login", staff.getStaffName());
            return SUCCESS;
        }
        return INPUT;
    }
    @SkipValidation
    public String getStaff(){
        staffs = service.getStaff();
        return SUCCESS;
    }

    public String addStaff(){
        Staff staff = service.addStaff(getModel());
        if (staff!=null){
            return SUCCESS;
        }
        return INPUT;
    }
    @SkipValidation
    public String getDept(){
        deptList = service.getDept();
        deptList.forEach(System.out::println);
        postList = deptService.getPostByDeptId(getModel().getPost().getDepartment());
        return SUCCESS;
    }


    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public List<Department> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<Department> deptList) {
        this.deptList = deptList;
    }

    public void setDeptService(DeptService deptService) {
        this.deptService = deptService;
    }

    public DeptService getDeptService() {
        return deptService;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }
}
