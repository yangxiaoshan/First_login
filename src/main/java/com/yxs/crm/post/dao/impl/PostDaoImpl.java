package com.yxs.crm.post.dao.impl;

import com.yxs.crm.post.dao.PostDao;
import com.yxs.crm.staff.domain.Post;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * Created by dllo on 17/11/11.
 */
public class PostDaoImpl extends HibernateDaoSupport implements PostDao {
    @Override
    public Post addPost(Post post) {
        getHibernateTemplate().save(post);
        return post;
    }
}
