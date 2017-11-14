package com.yxs.crm.post.dao.impl;

import com.yxs.crm.post.dao.PostDao;
import com.yxs.crm.staff.domain.Department;
import com.yxs.crm.staff.domain.Post;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public class PostDaoImpl extends HibernateDaoSupport implements PostDao {
    @Override
    public Post addPost(Post post) {
        if (post!=null&&post.getPostID()==0){
            getHibernateTemplate().save(post);
        }else {
            getHibernateTemplate().saveOrUpdate(post);
        }
        return post;
    }

    @Override
    public List<Post> getPost() {
        String sql = "from Post T_POST";
        return (List<Post>) getHibernateTemplate().find(sql);
    }

    @Override
    public List<Department> getDeptList() {
        String sql = "from Department T_DEPT";
        return (List<Department>) getHibernateTemplate().find(sql);
    }


}
