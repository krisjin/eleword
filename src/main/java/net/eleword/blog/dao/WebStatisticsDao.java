package net.eleword.blog.dao;

import net.eleword.blog.dao.common.BaseDao;
import net.eleword.blog.entity.WebStatistics;
import net.eleword.blog.util.Pagination;

/**
 * TODO 此处填写 class 信息
 * @author krisjin (mailto:krisjin86@163.com)
 */
public interface WebStatisticsDao extends BaseDao<WebStatistics> {
	
	Pagination<WebStatistics> selectWebStatisticsWithPage(Pagination<WebStatistics> page);
	
}

