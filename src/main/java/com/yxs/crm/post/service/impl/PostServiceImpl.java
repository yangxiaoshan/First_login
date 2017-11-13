package com.yxs.crm.post.service.impl;

import com.yxs.crm.post.dao.PostDao;
import com.yxs.crm.post.service.PostService;
import com.yxs.crm.staff.domain.Department;
import com.yxs.crm.staff.domain.Post;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public class PostServiceImpl implements PostService {
    private PostDao postDao;

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public Post addPost(Post post) {
        return postDao.addPost(post);
    }

    @Override
    public List<Post> getPost() {
        return postDao.getPost();
    }

    @Override
    public List<Department> getDeptList() {
        return postDao.getDeptList();
    }

}
