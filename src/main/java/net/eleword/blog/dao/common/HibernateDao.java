package net.eleword.blog.dao.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.eleword.blog.dao.common.PropertyFilter.MatchType;
import net.eleword.blog.util.Pagination;
import net.eleword.blog.util.ReflectionUtils;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.impl.CriteriaImpl;
import org.hibernate.transform.ResultTransformer;
import org.springframework.util.Assert;

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

	/**
	 * 
	 * @Title: getAll
	 * @Description: 分页获取全部对象.
	 * @param page
	 * @return
	 */
	public Pagination<T> getAll(final Pagination<T> page) {
		return findPage(page);
	}

	/**
	 * 
	 * @Title: findPage
	 * @Description: 按HQL分页查询.
	 * @param page
	 *            分页参数. 注意不支持其中的orderBy参数.
	 * @param hql
	 *            hql语句.
	 * @param values
	 *            数量可变的查询参数，按顺序绑定
	 * @return 分页查询结果
	 */
	@SuppressWarnings("unchecked")
	public Pagination<T> findPage(final Pagination<T> page, final String hql, final Object... values) {
		Assert.notNull(page, "page不能为空");

		Query q = createQuery(hql, values);

		if (page.isAutoCount()) {
			long totalCount = countHqlResult(hql, values);
			page.setTotalRecords(totalCount);
		}

		setPageParameterToQuery(q, page);

		List result = q.list();
		page.setResultSet(result);
		return page;
	}

	/**
	 * 
	 * @Title: findPage
	 * @Description: 按HQL分页查询.
	 * @param page
	 *            分页参数. 注意不支持其中的orderBy参数.
	 * @param hql
	 * @param values
	 *            命名参数,按名称绑定
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Pagination<T> findPage(final Pagination<T> page, final String hql, final Map<String, ?> values) {
		Assert.notNull(page, "page不能为空");

		Query q = createQuery(hql, values);

		if (page.isAutoCount()) {
			long totalCount = countHqlResult(hql, values);
			page.setTotalRecords(totalCount);
		}

		setPageParameterToQuery(q, page);

		List result = q.list();
		page.setResultSet(result);
		return page;
	}

	/**
	 * 
	 * @Title: findPage
	 * @Description: 按Criteria分页查询.
	 * @param page
	 *            分页参数.
	 * @param criterions
	 *            数量可变的Criterion.
	 * @return 分页查询结果
	 */
	@SuppressWarnings("unchecked")
	protected Pagination<T> findPage(final Pagination<T> page, final Criterion... criterions) {
		Assert.notNull(page, "page不能为空");

		Criteria c = createCriteria(criterions);

		if (page.isAutoCount()) {
			long totalCount = countCriteriaResult(c);
			page.setTotalRecords(totalCount);
		}

		setPageParameterToCriteria(c, page);

		List result = c.list();
		page.setResultSet(result);
		return page;
	}

	/**
	 * 
	 * @Title: setPageParameterToQuery
	 * @Description: 设置分页参数到Query对象,辅助函数.
	 * @param q
	 * @param page
	 * @return
	 */
	protected Query setPageParameterToQuery(final Query q, final Pagination<T> page) {

		Assert.isTrue(page.getPageSize() > 0, "Page Size must larger than zero");

		q.setFirstResult(page.getStartPage() - 1);
		q.setMaxResults(page.getPageSize() + page.getStartPage());
		return q;
	}

	/**
	 * 
	 * @Title: setPageParameterToCriteria
	 * @Description: 设置分页参数到Criteria对象,辅助函数.
	 * @param c
	 * @param page
	 * @return
	 */
	protected Criteria setPageParameterToCriteria(final Criteria c, final Pagination<T> page) {

		Assert.isTrue(page.getPageSize() > 0, "Page Size must larger than zero");

		c.setFirstResult(page.getStartPage() - 1);
		c.setMaxResults(page.getPageSize());

		if (page.isOrderBySetted()) {
			String[] orderByArray = StringUtils.split(page.getOrderProperty(), ',');
			String[] orderArray = StringUtils.split(page.getOrder(), ',');

			Assert.isTrue(orderByArray.length == orderArray.length, "分页多重排序参数中,排序字段与排序方向的个数不相等");

			for (int i = 0; i < orderByArray.length; i++) {
				if (Pagination.ASC.equals(orderArray[i])) {
					c.addOrder(Order.asc(orderByArray[i]));
				} else {
					c.addOrder(Order.desc(orderByArray[i]));
				}
			}
		}
		return c;
	}

	/**
	 * 
	 * @Title: countHqlResult
	 * @Description: 执行count查询获得本次Hql查询所能获得的对象总数.
	 *               本函数只能自动处理简单的hql语句,复杂的hql查询请另行编写count语句查询.
	 * @param hql
	 * @param values
	 * @return
	 */
	protected long countHqlResult(final String hql, final Object... values) {
		String countHql = prepareCountHql(hql);

		try {
			Long count = findUnique(countHql, values);
			return count == null ? 0 : count;
		} catch (Exception e) {
			throw new RuntimeException("hql can't be auto count, hql is:" + countHql, e);
		}
	}

	/**
	 * 
	 * @Title: countHqlResult
	 * @Description: 执行count查询获得本次Hql查询所能获得的对象总数.
	 *               本函数只能自动处理简单的hql语句,复杂的hql查询请另行编写count语句查询.
	 * @param hql
	 * @param values
	 * @return
	 */
	protected long countHqlResult(final String hql, final Map<String, ?> values) {
		String countHql = prepareCountHql(hql);

		try {
			Long count = findUnique(countHql, values);
			return count;
		} catch (Exception e) {
			throw new RuntimeException("hql can't be auto count, hql is:" + countHql, e);
		}
	}

	/**
	 * 
	 * @Title: prepareCountHql
	 * @Description: 去除order by
	 * @param orgHql
	 * @return
	 */
	private String prepareCountHql(String orgHql) {
		// String fromHql = orgHql;
		// fromHql = "from " + StringUtils.substringAfter(fromHql, "from");
		// fromHql = StringUtils.substringBefore(fromHql, "order by");
		// String groupBy = StringUtils.substring(fromHql,
		// fromHql.indexOf("group by")+8);
		// fromHql = StringUtils.substringBefore(fromHql, "group by");
		// String countHql = "select count(*) " + fromHql;
		// if(StringUtils.indexOf(orgHql, "group by") != -1){
		// countHql = "select count(distinct "+groupBy+") " + fromHql;
		// }
		// return countHql;
		String fromHql = orgHql;
		fromHql = "from " + StringUtils.substringAfter(fromHql, "from");
		fromHql = StringUtils.substringBefore(fromHql, "order by");
		fromHql = StringUtils.substringBefore(fromHql, "group by");

		String countHql = "select count(*) " + fromHql;
		return countHql;
	}

	/**
	 * 
	 * @Title: countCriteriaResult
	 * @Description: 执行count查询获得本次Criteria查询所能获得的对象总数.
	 * @param c
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected long countCriteriaResult(final Criteria c) {
		CriteriaImpl impl = (CriteriaImpl) c;

		// 先把Projection、ResultTransformer、OrderBy取出来,清空三者后再执行Count操作
		Projection projection = impl.getProjection();
		ResultTransformer transformer = impl.getResultTransformer();

		List<CriteriaImpl.OrderEntry> orderEntries = null;
		try {
			orderEntries = (List) ReflectionUtils.getFieldValue(impl, "orderEntries");
			ReflectionUtils.setFieldValue(impl, "orderEntries", new ArrayList());
		} catch (Exception e) {
			logger.error("不可能抛出的异常:{}", e.getMessage());
		}

		// 执行Count查询
		Integer totalCountObject = (Integer) c.setProjection(Projections.rowCount()).uniqueResult();
		long totalCount = (totalCountObject != null) ? totalCountObject : 0;

		// 将之前的Projection,ResultTransformer和OrderBy条件重新设回去
		c.setProjection(projection);

		if (projection == null) {
			c.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		}
		if (transformer != null) {
			c.setResultTransformer(transformer);
		}
		try {
			ReflectionUtils.setFieldValue(impl, "orderEntries", orderEntries);
		} catch (Exception e) {
			logger.error("不可能抛出的异常:{}", e.getMessage());
		}

		return totalCount;
	}

	/**
	 * 
	 * @Title: findBy
	 * @Description: 按属性查找对象列表,支持多种匹配方式.
	 * @param propertyName
	 * @param value
	 * @param matchType
	 *            匹配方式,目前支持的取值见PropertyFilter的MatcheType enum.
	 * @return
	 */
	public List<T> findBy(final String propertyName, final Object value, final MatchType matchType) {
		Criterion criterion = buildCriterion(propertyName, value, matchType);
		return find(criterion);
	}

	/**
	 * 
	 * @Title: find
	 * @Description: 按属性过滤条件列表查找对象列表.
	 * @param filters
	 * @return
	 */
	public List<T> find(List<PropertyFilter> filters) {
		Criterion[] criterions = buildCriterionByPropertyFilter(filters);
		return find(criterions);
	}

	/**
	 * 
	 * @Title: findPage
	 * @Description: 按属性过滤条件列表分页查找对象.
	 * @param page
	 * @param filters
	 * @return
	 */
	public Pagination<T> findPage(final Pagination<T> page, final List<PropertyFilter> filters) {
		Criterion[] criterions = buildCriterionByPropertyFilter(filters);
		return findPage(page, criterions);
	}

	/**
	 * 
	 * @Title: buildCriterion
	 * @Description: 按属性条件参数创建Criterion,辅助函数.
	 * @param propertyName
	 * @param propertyValue
	 * @param matchType
	 * @return
	 */
	protected Criterion buildCriterion(final String propertyName, final Object propertyValue, final MatchType matchType) {
		Assert.hasText(propertyName, "propertyName不能为空");
		Criterion criterion = null;
		// 根据MatchType构造criterion
		switch (matchType) {
		case EQ:
			criterion = Restrictions.eq(propertyName, propertyValue);
			break;
		case LIKE:
			criterion = Restrictions.like(propertyName, (String) propertyValue, MatchMode.ANYWHERE);
			break;
		case LE:
			criterion = Restrictions.le(propertyName, propertyValue);
			break;
		case LT:
			criterion = Restrictions.lt(propertyName, propertyValue);
			break;
		case GE:
			criterion = Restrictions.ge(propertyName, propertyValue);
			break;
		case GT:
			criterion = Restrictions.gt(propertyName, propertyValue);
		}
		return criterion;
	}

	/**
	 * 
	 * @Title: buildCriterionByPropertyFilter
	 * @Description: 按属性条件列表创建Criterion数组,辅助函数.
	 * @param filters
	 * @return
	 */
	protected Criterion[] buildCriterionByPropertyFilter(final List<PropertyFilter> filters) {
		List<Criterion> criterionList = new ArrayList<Criterion>();
		for (PropertyFilter filter : filters) {
			if (!filter.hasMultiProperties()) { // 只有一个属性需要比较的情况.
				Criterion criterion = buildCriterion(filter.getPropertyName(), filter.getMatchValue(), filter.getMatchType());
				criterionList.add(criterion);
			} else {// 包含多个属性需要比较的情况,进行or处理.
				Disjunction disjunction = Restrictions.disjunction();
				for (String param : filter.getPropertyNames()) {
					Criterion criterion = buildCriterion(param, filter.getMatchValue(), filter.getMatchType());
					disjunction.add(criterion);
				}
				criterionList.add(disjunction);
			}
		}
		return criterionList.toArray(new Criterion[criterionList.size()]);
	}

	public List<Map<String, Object>> findPageBySql(final String sql, final Object... values) {
		SQLQuery q = createSqlQuery(sql, values);

		List result = q.list();
		return result;
	}
}
