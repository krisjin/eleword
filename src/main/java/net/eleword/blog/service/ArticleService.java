package net.eleword.blog.service;

import net.eleword.blog.dao.ArticleDao;
import net.eleword.blog.entity.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-1-29上午6:33:24
 */
@Service
public class ArticleService {

	@Autowired
	private ArticleDao articleDao;

	public Long addArticle(Article article) {
		return articleDao.add(article);
	}

	public void deleteById(long id) {
		articleDao.deleteById(id);
	}

	public void updateById(Article article) {
		articleDao.update(article);
	}

	public Article queryById(long id) {
		return articleDao.select(id);
	}

	public ArticleDao getArticleDao() {
		return articleDao;
	}

	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

}
