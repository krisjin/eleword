package net.eleword.blog.dao;

import net.eleword.blog.search.entity.LuceneArticle;
import net.eleword.blog.util.Pagination;

/**
 * TODO 此处填写 class 信息
 * @author krisjin (mailto:krisjin86@163.com)
 */
public interface ArticleSearchDao {
	public Pagination<LuceneArticle> selectArticleIndexWithPage(Pagination<LuceneArticle> page);
}

