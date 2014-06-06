package net.eleword.blog.dao.impl;

import net.eleword.blog.dao.ArticleSearchDao;
import net.eleword.blog.dao.common.HibernateDao;
import net.eleword.blog.search.entity.Articles;
import net.eleword.blog.util.Pagination;

import org.springframework.stereotype.Repository;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin 
 * @date 2014-4-29下午5:00:49
 */
@Repository("aritcleSearchDao")
public class AritcleSearchDaoImpl extends HibernateDao<Articles, Long> implements ArticleSearchDao{
	public Pagination<Articles> selectArticleIndexWithPage(Pagination<Articles> page) {

		String hql = "select new net.eleword.blog.search.entity.Articles(id,title,content) from Article ";

		return findPage(page, hql);
	}

}
