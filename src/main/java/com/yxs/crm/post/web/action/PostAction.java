package com.yxs.crm.post.web.action;

import com.yxs.crm.base.BaseAction;
import com.yxs.crm.post.service.PostService;
import com.yxs.crm.staff.domain.Post;

/**
 * Created by dllo on 17/11/11.
 */
public class PostAction extends BaseAction<Post,PostService> {
    public String addPost(){
        Post post = service.addPost(getModel());
        if (post != null){
            return SUCCESS;
        }
        return INPUT;
    }
}
