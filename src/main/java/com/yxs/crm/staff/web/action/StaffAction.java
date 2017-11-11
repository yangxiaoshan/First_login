package com.yxs.crm.staff.web.action;

import com.yxs.crm.base.BaseAction;
import com.yxs.crm.staff.domain.Staff;
import com.yxs.crm.staff.service.StaffService;

/**
 * Created by dllo on 17/11/10.
 */
public class StaffAction extends BaseAction<Staff,StaffService>{
    public String login(){

        Staff staff = service.login(getModel());
        if (staff != null) {
            sessionPut("login", staff.getLoginName());
            return SUCCESS;
        }
        return INPUT;

    }
}
