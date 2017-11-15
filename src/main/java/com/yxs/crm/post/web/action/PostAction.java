package com.yxs.crm.post.web.action;

import com.yxs.crm.base.BaseAction;
import com.yxs.crm.post.service.PostService;
import com.yxs.crm.staff.domain.Department;
import com.yxs.crm.staff.domain.Post;
import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public class PostAction extends BaseAction<Post, PostService> {
    private List<Post> posts;
    private List<Department> departments;

    public String addPost() {


        Post post = service.addPost(getModel());
        if (post != null) {
            return SUCCESS;
        }
        return INPUT;
    }

    public String getPost() {

        posts = service.getPost();
        return SUCCESS;
    }
    public String getDeptList(){
        departments=service.getDeptList();
        return SUCCESS;
    }


    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }


}


