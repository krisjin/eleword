
package net.eleword.blog.dao.impl;

import net.eleword.blog.dao.CategoryDao;
import net.eleword.blog.dao.common.HibernateDao;
import net.eleword.blog.entity.Category;

import org.springframework.stereotype.Repository;

/**
 * TODO 此处填写 class 信息
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-1-27上午6:23:22
 */
@Repository("categoryDao")
public class CategoryDaoImpl extends HibernateDao<Category,Long> implements CategoryDao{

	public Long add(Category entity) {
		return (Long) save(entity);
	}

	public void update(Category entity) {
		
	}

	public void delete(long id) {
		
	}

	public int select(long id) {
		return 0;
	}

}

