
package net.eleword.blog.dao.impl;

import java.util.List;

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
		saveOrUpdate(entity);
	}

	public void deleteById(long id) {
		delete(id);
	}

	public Category select(long id) {
	
		return get(id);
	}

	public List<Category> selectAll(){
		
		return getAll("priority",true);
	}
	
}

