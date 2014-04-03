package net.eleword.blog.dao;

import java.util.List;

import net.eleword.blog.dao.common.BaseDao;
import net.eleword.blog.entity.Article;
import net.eleword.blog.util.Pagination;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-1-26下午1:32:19
 */

public interface ArticleDao extends BaseDao<Article> {

	/**
	 * @return
	 */
	List<Article> selectAll();

	/**
	 * @param page
	 * @return
	 */
	Pagination<Article> selectArticleWithPage(Pagination<Article> page);

	/**
	 * @param page
	 * @param categoryId
	 * @return
	 */
	Pagination<Article> selectArticleWithPageByCategoryId(Pagination<Article> page, long categoryId);

	List selectArticleArchive();

	Pagination<Article> selectArticleByArchiveDate(Pagination<Article> page, String date);
}
