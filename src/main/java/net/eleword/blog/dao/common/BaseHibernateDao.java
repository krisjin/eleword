package net.eleword.blog.dao.common;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import net.eleword.blog.util.ReflectionUtils;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-1-27上午6:30:58
 */
public abstract class BaseHibernateDao<T, PK extends Serializable> {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected SessionFactory sessionFactory;

	protected Class<T> entityClass;

	/**
	 * 用于Dao层子类使用的构造函数.通过子类的泛型定义取得对象类型Class
	 */
	public BaseHibernateDao() {
		this.entityClass = ReflectionUtils.getSuperClassGenricType(getClass());
	}

	/**
	 * 用于省略Dao层, 在Service层直接使用通用SimpleHibernateDao的构造函数.在构造函数中定义对象类型Class.
	 * 
	 * @param sessionFactory
	 * @param entityClass
	 */
	public BaseHibernateDao(final SessionFactory sessionFactory, final Class<T> entityClass) {
		this.sessionFactory = sessionFactory;
		this.entityClass = entityClass;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * 采用@Autowired按类型注入SessionFactory, 当有多个SesionFactory的时候在子类重载本函数
	 * 
	 * @param sessionFactory
	 */
	@Autowired
	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 保存新增的对象
	 * 
	 * @param entity
	 * @return
	 */
	public Serializable save(final T entity) {
		return getSession().save(entity);
	}

	/**
	 * 保存新增的对象
	 * 
	 * @param entity
	 */
	public void persist(final T entity) {
		getSession().persist(entity);
	}

	public void saveOrUpdate(final T entity) {
		getSession().saveOrUpdate(entity);
		logger.debug("save entity: {}", entity);
	}

	/**
	 * 更新一个对象
	 * 
	 * @param entity
	 */
	public void merge(final T entity) {
		getSession().merge(entity);
	}

	/**
	 * 删除对象
	 * 
	 * @param entity
	 *            对象必须是session中的对象或含id属性的transient对象
	 */
	public void delete(final T entity) {
		getSession().delete(entity);
		logger.debug("delete entity: {}", entity);
	}

	/**
	 * 按id删除对象
	 * 
	 * @param id
	 */
	public void delete(final PK id) {
		delete(get(id));
		logger.debug("delete entity {},id is {}", entityClass.getSimpleName(), id);
	}

	public T get(final PK id) {
		return (T) getSession().get(entityClass, id);
	}

	/**
	 * 按id列表获取对象列表
	 * 
	 * @param ids
	 * @return
	 */
	public List<T> get(final Collection<PK> ids) {
		return find(Restrictions.in(getIdName(), ids));
	}

	/**
	 * 获取全部对象.
	 * 
	 * @return
	 */
	public List<T> getAll() {
		return find();
	}

	/**
	 * 获取全部对象, 支持按属性行序
	 * 
	 * @param orderByProperty
	 * @param isAsc
	 * @return
	 */
	public List<T> getAll(String orderByProperty, boolean isAsc) {
		Criteria c = createCriteria();
		if (isAsc) {
			c.addOrder(Order.asc(orderByProperty));
		} else {
			c.addOrder(Order.desc(orderByProperty));
		}
		return c.list();
	}

	/**
	 * 按属性查找对象列表, 匹配方式为相等
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public List<T> findBy(final String propertyName, final Object value) {
		Criterion criterion = Restrictions.eq(propertyName, value);
		return find(criterion);
	}

	/**
	 * 按属性查找唯一对象, 匹配方式为相等.
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public T findUniqueBy(final String propertyName, final Object value) {
		Criterion criterion = Restrictions.eq(propertyName, value);
		return (T) createCriteria(criterion).uniqueResult();
	}

	/**按HQL查询对象列表.
	 * @param hql
	 * @param values 数量可变的参数,按顺序绑定.
	 * @return
	 */
	public <X> List<X> find(final String hql, final Object... values) {
		return createQuery(hql, values).list();
	}

	/**
	 * 按HQL查询对象列表从第多少条到第多少条记录.
	 * 
	 * @param hql
	 * @param first
	 *            起始条数
	 * @param last
	 *            结束条数
	 * @param values
	 *            数量可变的参数,按顺序绑定.
	 * @return
	 */
	public <X> List<X> find(final String hql, final int first, final int last, final Object... values) {
		Query query = createQuery(hql, values);
		query.setFirstResult(first);
		query.setMaxResults(last);
		return query.list();
	}

	/**
	 * 按HQL查询对象列表
	 * 
	 * @param hql
	 * @param values
	 *            命名参数,按名称绑定.
	 * @return
	 */
	public <X> List<X> find(final String hql, final Map<String, ?> values) {
		return createQuery(hql, values).list();
	}

	/**
	 * 按HQL查询唯一对象.
	 * 
	 * @param hql
	 * @param values
	 *            数量可变的参数,按顺序绑定.
	 * @return
	 */
	public <X> X findUnique(final String hql, final Object... values) {
		return (X) createQuery(hql, values).uniqueResult();
	}

	/**
	 * 按HQL查询唯一对象.
	 * 
	 * @param hql
	 * @param values
	 *            命名参数,按名称绑定.
	 * @return
	 */
	public <X> X findUnique(final String hql, final Map<String, ?> values) {
		return (X) createQuery(hql, values).uniqueResult();
	}

	/**
	 * 执行HQL进行批量修改/删除操作
	 * 
	 * @param hql
	 * @param values
	 *            数量可变的参数,按顺序绑定.
	 * @return 更新记录数
	 */
	public int batchExecute(final String hql, final Object... values) {
		return createQuery(hql, values).executeUpdate();
	}

	/**
	 * 执行HQL进行批量修改/删除操作.
	 * 
	 * @param hql
	 * @param values
	 *            命名参数,按名称绑定.
	 * @return 更新记录数.
	 */
	public int batchExecute(final String hql, final Map<String, ?> values) {
		return createQuery(hql, values).executeUpdate();
	}

	public int batchExecute(final String hql, final String arg, final Long[] values) {
		return createQuery(hql, arg, values).executeUpdate();
	}

	/**
	 * 
	 * @Title: createQuery
	 * @Description: 根据查询HQL与参数列表创建Query对象.与find()函数可进行更加灵活的操作.
	 * @param queryString
	 * @param values
	 * @return
	 */
	protected Query createQuery(final String queryString, final Object... values) {
		Query query = getSession().createQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		query.setCacheable(true);
		return query;
	}

	/**
	 * 
	 * @Title: createQuery
	 * @Description: 根据查询HQL与参数列表创建Query对象.与find()函数可进行更加灵活的操作.
	 * @param queryString
	 * @param values
	 *            命名参数,按名称绑定.
	 * @return
	 */
	protected Query createQuery(final String queryString, final Map<String, ?> values) {
		Query query = getSession().createQuery(queryString);
		if (values != null) {
			query.setProperties(values);
		}
		query.setCacheable(true);
		return query;
	}

	/**根据查询HQL与参数列表创建Query对象.与find()函数可进行更加灵活的操作.
	 * @param queryString
	 * @param arg
	 * @param values
	 * @return
	 */
	protected Query createQuery(final String queryString, final String arg, final Long[] values) {
		Query query = getSession().createQuery(queryString);
		if (values != null && values.length > 0) {
			query.setParameterList(arg, values);
		}
		return query;
	}

	/**
	 * 
	 * @Title: find
	 * @Description: 按Criteria查询对象列表.
	 * @param criterions
	 *            数量可变的Criterion.
	 * @return
	 */
	protected List<T> find(final Criterion... criterions) {
		return createCriteria(criterions).list();
	}

	/**
	 * 按Criteria查询唯一对象
	 * 
	 * @param criterions
	 *            数量可变的Criterion
	 * @return
	 */
	public T findUnique(final Criterion... criterions) {
		return (T) createCriteria(criterions).uniqueResult();
	}

	/**
	 * 根据Criterion条件创建Criteria.与find()函数可进行更加灵活的操作
	 * 
	 * @param criterions
	 * @return
	 */
	protected Criteria createCriteria(final Criterion... criterions) {
		Criteria criteria = getSession().createCriteria(entityClass);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		criteria.setCacheable(true);
		return criteria;
	}

	/**
	 * <p>
	 * 初始化对象.
	 * </p>
	 * 使用load()方法得到的仅是对象Proxy, 在传到View层前需要进行初始化. 如果传入entity,
	 * 则只初始化entity的直接属性,但不会初始化延迟加载的关联集合和属性. 如需初始化关联属性,需执行:
	 * Hibernate.initialize(user.getRoles())，初始化User的直接属性和关联集合.
	 * Hibernate.initialize
	 * (user.getDescription())，初始化User的直接属性和延迟加载的Description属性.
	 * 
	 * @param proxy
	 */
	public void initProxyObject(Object proxy) {
		Hibernate.initialize(proxy);
	}

	/**
	 * Flush当前Session
	 */
	public void flush() {
		getSession().flush();
	}

	/**
	 * 为Query添加distinct transformer. 预加载关联对象的HQL会引起主对象重复, 需要进行distinct处理.
	 * 
	 * @param query
	 * @return
	 */
	private Query distinct(Query query) {
		query.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return query;
	}

	/**
	 * 为Criteria添加distinct transformer. 预加载关联对象的HQL会引起主对象重复, 需要进行distinct处理
	 * 
	 * @param criteria
	 * @return
	 */
	private Criteria distinct(Criteria criteria) {
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return criteria;
	}

	/**
	 * 取得对象的主键名
	 * 
	 * @return
	 */
	public String getIdName() {
		ClassMetadata meta = getSessionFactory().getClassMetadata(entityClass);
		return meta.getIdentifierPropertyName();
	}

	/**
	 * 判断对象的属性值在数据库内是否唯一. 在修改对象的情景下,如果属性新修改的值(value)等于属性原来的值(orgValue)则不作比较.
	 * 
	 * @param propertyName
	 * @param newValue
	 * @param oldValue
	 * @return
	 */
	public boolean isPropertyUnique(final String propertyName, final Object newValue, final Object oldValue) {
		if (newValue == null || newValue.equals(oldValue)) {
			return true;
		}
		Object object = findUniqueBy(propertyName, newValue);
		return (object == null);
	}

	protected SQLQuery createSqlQuery(final String sqlString, final Object... values) {
		SQLQuery query = getSession().createSQLQuery(sqlString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query;
	}

}
