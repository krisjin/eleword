package net.eleword.blog.search.task;

import java.util.List;

import net.eleword.blog.dao.impl.LuceneAritcleDao;
import net.eleword.blog.search.entity.LuceneArticle;
import net.eleword.blog.util.Pagination;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-4-29下午4:22:24
 */

public class ArticleIndexTask {

	private String indexPath;

	@Autowired
	private LuceneAritcleDao luceneAritcleDao;

	private void createIndex() {

		Pagination<LuceneArticle> tempPage = new Pagination<LuceneArticle>();
		tempPage.setPageSize(100);
		tempPage.setCurrentPage(1);
		tempPage = luceneAritcleDao.selectArticleIndexWithPage(tempPage);

		int totalPage = tempPage.getTotalPages();
		Pagination<LuceneArticle> page = new Pagination<LuceneArticle>();
		page.setPageSize(100);

		for (int i = 1; i <= totalPage; i++) {
			ArticleIndex articleIndex = new ArticleIndex();
			page.setCurrentPage(i);
			page = luceneAritcleDao.selectArticleIndexWithPage(page);
			articleIndex.create(page.getResultSet(), indexPath);
		}
	}

	public LuceneAritcleDao getLuceneAritcleDao() {
		return luceneAritcleDao;
	}

	public void setLuceneAritcleDao(LuceneAritcleDao luceneAritcleDao) {
		this.luceneAritcleDao = luceneAritcleDao;
	}
	
	
}
