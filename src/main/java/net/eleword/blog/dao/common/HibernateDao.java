package net.eleword.blog.dao.common;

import java.io.Serializable;

import org.hibernate.SessionFactory;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-1-27上午6:42:20
 */
public abstract class HibernateDao<T, PK extends Serializable> extends BaseHibernateDao<T, PK> {

	/**
	 * 用于Dao层子类的构造函数，通过子类的泛型定义取得对象类型Class
	 */
	public HibernateDao() {
		super();
	}

	/**
	 * @param sessionFactory
	 * @param entityClass
	 */
	public HibernateDao(final SessionFactory sessionFactory, final Class<T> entityClass) {
		super(sessionFactory, entityClass);
	}
}
