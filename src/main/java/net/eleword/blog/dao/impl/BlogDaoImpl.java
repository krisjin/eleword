package net.eleword.blog.dao.impl;

import net.eleword.blog.dao.BlogDao;
import net.eleword.blog.dao.common.HibernateDao;
import net.eleword.blog.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin
 */
@Repository("blogDao")
public class BlogDaoImpl extends HibernateDao<Blog, Long> implements BlogDao {

    public Long add(Blog entity) {

        return null;
    }

    public void update(Blog entity) {
        saveOrUpdate(entity);
    }

    public void deleteById(long id) {

    }

    public Blog select(long id) {
        return select(id);
    }

    public List<Blog> getAllBlogConfig() {
        return getAll();
    }

}
