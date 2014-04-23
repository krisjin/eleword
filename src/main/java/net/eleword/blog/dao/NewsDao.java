package net.eleword.blog.dao;

import net.eleword.blog.dao.common.BaseDao;
import net.eleword.blog.entity.News;
import net.eleword.blog.util.Pagination;


/**
 * TODO 此处填写 class 信息
 * @author krisjin (mailto:krisjin86@163.com)
 */
public interface NewsDao extends BaseDao<News> {
	
	Pagination<News> selectNewsWithPage(Pagination<News> page);

}

