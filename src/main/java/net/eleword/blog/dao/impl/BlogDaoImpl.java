package net.eleword.blog.dao.impl;

import org.springframework.stereotype.Repository;

import net.eleword.blog.dao.BlogDao;
import net.eleword.blog.dao.common.HibernateDao;
import net.eleword.blog.entity.Blog;

/**
 * TODO 此处填写 class 信息
 * @author krisjin (mailto:krisjin86@163.com)
 */
@Repository("blogDao")
public class BlogDaoImpl  extends HibernateDao<Blog, Long> implements BlogDao{

	public Long add(Blog entity) {
		
		return null;
	}

	public void update(Blog entity) {
		saveOrUpdate(entity);
	}

	public void deleteById(long id) {
		
	}

	public Blog select(long id) {
		
		return null;
	}

}

