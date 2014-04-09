
package net.eleword.blog.dao.impl;

import net.eleword.blog.dao.CategoryDao;
import net.eleword.blog.dao.common.HibernateDao;
import net.eleword.blog.entity.Category;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 文章分类数据访问层实现
 *
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-1-27上午6:23:22
 */
@Repository("categoryDao")
public class CategoryDaoImpl extends HibernateDao<Category, Long> implements CategoryDao {

	public Long add(Category entity) {
		return (Long) save(entity);
	}

	public void update(Category entity) {
		Query query = createQuery("update Category set name=? ,orderValue=?  where id=?", entity.getName(), entity.getOrderValue(), entity.getId());
		query.executeUpdate();
	}

	public void updateArticleNumber(Category entity) {
		saveOrUpdate(entity);
	}

	public void deleteById(long id) {
		delete(id);
	}

	public Category select(long id) {

		return get(id);
	}

	public List<Category> selectAll() {

		return getAll("orderValue", true);
	}

}

