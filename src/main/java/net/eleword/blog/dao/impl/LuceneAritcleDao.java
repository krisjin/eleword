package net.eleword.blog.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.eleword.blog.dao.common.HibernateDao;
import net.eleword.blog.search.entity.LuceneArticle;
import net.eleword.blog.util.Pagination;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-4-29下午5:00:49
 */
@Repository("luceneAritcleDao")
public class LuceneAritcleDao extends HibernateDao<LuceneArticle, Long> {
	public Pagination<LuceneArticle> selectArticleIndexWithPage(Pagination<LuceneArticle> page) {

		String hql = "select new net.eleword.blog.search.entity.LuceneArticle(id,title,content) from Article ";

		return findPage(page, hql);
	}

}
