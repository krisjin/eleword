package net.eleword.blog.dao;

import java.util.List;

import net.eleword.blog.dao.common.BaseDao;
import net.eleword.blog.entity.Article;
import net.eleword.blog.search.entity.Articles;
import net.eleword.blog.util.Pagination;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin 
 * @date 2014-1-26下午1:32:19
 */

public interface ArticleDao extends BaseDao<Article> {

	List<Article> selectAll();

	Pagination<Article> selectArticleWithPage(Pagination<Article> page);

	Pagination<Article> selectArticleWithPageByCategoryId(Pagination<Article> page, long categoryId);

	List selectArticleArchive();

	Pagination<Article> selectArticleByArchiveDate(Pagination<Article> page, String date);

	List<Article> selectRecentArticle(int size);
	
}
