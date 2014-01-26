package net.eleword.blog.dao.common;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-1-26下午1:39:27
 */

public interface BaseDao<T> {
	
	int add(T entity);

	void update(T entity);

	void delete(long id);

	int select(long id);
	
}
