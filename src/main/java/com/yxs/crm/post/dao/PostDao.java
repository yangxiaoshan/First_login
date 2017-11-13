package com.yxs.crm.post.dao;

import com.yxs.crm.staff.domain.Department;
import com.yxs.crm.staff.domain.Post;

import java.util.List;


/**
 * Created by dllo on 17/11/11.
 */
public interface PostDao {
    Post addPost(Post post);
    List<Post> getPost();
    List<Department> getDeptList();
}
