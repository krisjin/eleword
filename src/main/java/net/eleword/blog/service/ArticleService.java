package net.eleword.blog.service;

import java.util.List;

import net.eleword.blog.dao.ArticleDao;
import net.eleword.blog.entity.Article;
import net.eleword.blog.util.Pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin 
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

	public List<Article> selectAll() {
		return articleDao.selectAll();
	}

	public Pagination<Article> selectArticleWithPage(Pagination page) {

		return articleDao.selectArticleWithPage(page);
	}

	public Pagination<Article> selectArticleWithPageByCategoryId(Pagination<Article> page, long categoryId) {

		return articleDao.selectArticleWithPageByCategoryId(page, categoryId);
	}

	public List queryArticleArchive() {
		return articleDao.selectArticleArchive();
	}

	public Pagination<Article> selectArticleArchiveDateWithPage(Pagination<Article> page, String date) {

		return articleDao.selectArticleByArchiveDate(page, date);
	}

	public List<Article> selectRecnetArticle(int size) {
		return articleDao.selectRecentArticle(size);
	}
}
