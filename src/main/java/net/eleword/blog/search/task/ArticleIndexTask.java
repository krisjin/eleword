package net.eleword.blog.search.task;

import net.eleword.blog.search.entity.LuceneArticle;
import net.eleword.blog.service.ArticleSearchService;
import net.eleword.blog.util.Pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-4-29下午4:22:24
 */
public class ArticleIndexTask {

	private String indexPath;

	@Autowired
	private ArticleSearchService articleSearchService;

	private void createIndex() {
		
		System.out.println("start----------------------------------");

		Pagination<LuceneArticle> tempPage = new Pagination<LuceneArticle>();
		tempPage.setPageSize(100);
		tempPage.setCurrentPage(1);
		tempPage = articleSearchService.getAritlce(tempPage);

		int totalPage = tempPage.getTotalPages();
		Pagination<LuceneArticle> page = new Pagination<LuceneArticle>();
		page.setPageSize(100);

		for (int i = 1; i <= totalPage; i++) {
			ArticleIndex articleIndex = new ArticleIndex();
			page.setCurrentPage(i);
			page = articleSearchService.getAritlce(page);
			articleIndex.create(page.getResultSet(), indexPath);
		}
		
		System.out.println("end----------------------------------");
	}

	public String getIndexPath() {
		return indexPath;
	}

	public void setIndexPath(String indexPath) {
		this.indexPath = indexPath;
	}
	
}
