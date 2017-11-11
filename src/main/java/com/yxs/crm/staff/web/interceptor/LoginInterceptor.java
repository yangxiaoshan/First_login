package com.yxs.crm.staff.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.yxs.crm.staff.domain.Department;
import com.yxs.crm.staff.domain.Staff;

/**
 * Created by dllo on 17/11/10.
 */
public class LoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation invocation) throws Exception {

        Staff login = (Staff) ActionContext.getContext().getSession().get("login");
//        login.getStaffID()
        if (login == null){
            return "input";
        }
        return invocation.invoke();
    }
}
