package net.eleword.blog.dao.impl;

import net.eleword.blog.dao.WebStatisticsDao;
import net.eleword.blog.dao.common.HibernateDao;
import net.eleword.blog.entity.WebStatistics;
import net.eleword.blog.util.Pagination;

import org.springframework.stereotype.Repository;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin 
 */
@Repository("webStatisticsDao")
public class WebStatisticsDaoImpl extends HibernateDao<WebStatistics, Long> implements WebStatisticsDao {

	public Long add(WebStatistics entity) {

		return (Long) save(entity);
	}

	public void update(WebStatistics entity) {

	}

	public void deleteById(long id) {
		delete(id);
	}

	public WebStatistics select(long id) {

		return null;
	}

	public Pagination<WebStatistics> selectWebStatisticsWithPage(Pagination<WebStatistics> page) {
		String hql = "from WebStatistics ws order by ws.date desc";
		return findPage(page, hql);
	}

}
