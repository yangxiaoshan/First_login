package com.yxs.crm.staff.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.yxs.crm.base.BaseAction;
import com.yxs.crm.department.service.DeptService;
import com.yxs.crm.staff.domain.Department;
import com.yxs.crm.staff.domain.Post;
import com.yxs.crm.staff.domain.Staff;
import com.yxs.crm.staff.service.StaffService;
import com.yxs.crm.utils.MD5Util;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public class StaffAction extends BaseAction<Staff, StaffService> {

    private List<Staff> staffs;
    private List<Department> deptList;
    private DeptService deptService;
    private List<Post> postList;
    private List<Staff> staffList;


    HttpServletRequest request = ServletActionContext.getRequest();
    HttpSession session = request.getSession();
    public String login() {

        Staff staff = service.login(getModel());
        if (staff != null) {
            sessionPut("login", staff.getStaffName());
            return SUCCESS;
        }
        return INPUT;
    }

    @SkipValidation
    public String reLogin() {
        session.invalidate();
        return SUCCESS;
    }

    @SkipValidation
    public String getStaff() {
        staffs = service.getStaff();
        deptList = service.getDept();
        return SUCCESS;
    }


    public String addStaff() {
        if (getModel().getStaffName().equals("")) {
//            deptList = service.getDept();
            addFieldError("msg","员工姓名不能为空");
            return INPUT;
        }
        //添加的员工密码加密
        String md5 = MD5Util.getMd5(getModel().getLoginPwd());
        getModel().setLoginPwd(md5);
        //加密后的密码存在员工对象里,存入数据库
        service.addStaff(getModel());
        return SUCCESS;
    }

    @SkipValidation
    public String getDept() {
        deptList = service.getDept();
        postList = deptService.getPostByDeptId(getModel().getPost().getDepartment());
        return SUCCESS;
    }

    @SkipValidation
    public String queryStaff() {
        staffList = service.queryStaff(getModel().getPost().getDepartment(), getModel().getPost(), getModel());
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

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }
}
