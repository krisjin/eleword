package net.eleword.blog.search.task;

import net.eleword.blog.search.entity.Articles;
import net.eleword.blog.service.ArticleSearchService;
import net.eleword.blog.util.Pagination;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-4-29下午4:22:24
 */
public class ArticleIndexTask {
	
	protected final Logger logger = LoggerFactory.getLogger(ArticleIndexTask.class);
	private String indexPath;

	@Autowired
	private ArticleSearchService articleSearchService;

	private void createIndex() {
		logger.info("start create article index......");
		Pagination<Articles> tempPage = new Pagination<Articles>();
		tempPage.setPageSize(100);
		tempPage.setCurrentPage(1);
		tempPage = articleSearchService.getAritlce(tempPage);

		int totalPage = tempPage.getTotalPages();
		Pagination<Articles> page = new Pagination<Articles>();
		page.setPageSize(100);

		for (int i = 1; i <= totalPage; i++) {
			ArticleIndex articleIndex = new ArticleIndex();
			page.setCurrentPage(i);
			page = articleSearchService.getAritlce(page);
			articleIndex.create(page.getResultSet(), indexPath);
		}
		
		logger.info("end create article index ......");
	}

	private void updateIndex(){
		
		logger.info("start update article index......");
		Pagination<Articles> tempPage = new Pagination<Articles>();
		tempPage.setPageSize(100);
		tempPage.setCurrentPage(1);
		tempPage = articleSearchService.getAritlce(tempPage);

		int totalPage = tempPage.getTotalPages();
		Pagination<Articles> page = new Pagination<Articles>();
		page.setPageSize(100);

		for (int i = 1; i <= totalPage; i++) {
			ArticleIndex articleIndex = new ArticleIndex();
			page.setCurrentPage(i);
			page = articleSearchService.getAritlce(page);
			articleIndex.update(page.getResultSet(), indexPath);
		}
		logger.info("end update article index ......");
	}
	
	public String getIndexPath() {
		return indexPath;
	}

	public void setIndexPath(String indexPath) {
		this.indexPath = indexPath;
	}
	
}
