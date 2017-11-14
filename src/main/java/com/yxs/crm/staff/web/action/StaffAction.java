package com.yxs.crm.staff.web.action;

import com.yxs.crm.base.BaseAction;
import com.yxs.crm.staff.domain.Department;
import com.yxs.crm.staff.domain.Staff;
import com.yxs.crm.staff.service.StaffService;
import org.apache.struts2.interceptor.validation.SkipValidation;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public class StaffAction extends BaseAction<Staff,StaffService>{

    private List<Staff> staffs;
//    private List<Department> departments;

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


    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

//    public List<Department> getDepartments() {
//        return departments;
//    }
//
//    public void setDepartments(List<Department> departments) {
//        this.departments = departments;
//    }
}
