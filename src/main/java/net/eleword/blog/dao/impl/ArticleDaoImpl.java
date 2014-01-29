package net.eleword.blog.dao.impl;

import org.springframework.stereotype.Repository;

import net.eleword.blog.dao.ArticleDao;
import net.eleword.blog.dao.common.HibernateDao;
import net.eleword.blog.entity.Article;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-1-27上午6:25:10
 */
@Repository("articleDao")
public class ArticleDaoImpl extends HibernateDao<Article, Long> implements ArticleDao {

	public Long add(Article entity) {

		return (Long) save(entity);
	}

	public void update(Article entity) {
		saveOrUpdate(entity);
	}

	public void deleteById(long id) {
		delete(id);
	}

	public Article select(long id) {

		return get(id);
	}

}
