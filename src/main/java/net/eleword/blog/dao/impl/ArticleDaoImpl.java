package net.eleword.blog.dao.impl;

import net.eleword.blog.dao.ArticleDao;
import net.eleword.blog.dao.common.HibernateDao;
import net.eleword.blog.entity.Article;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-1-27上午6:25:10
 */
public class ArticleDaoImpl extends HibernateDao<Article,Long> implements ArticleDao  {

	public Long add(Article entity) {

		return 0L;
	}

	public void update(Article entity) {

	}

	public void delete(long id) {

	}

	public int select(long id) {

		return 0;
	}

}
