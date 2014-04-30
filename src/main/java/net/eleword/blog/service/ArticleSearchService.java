package net.eleword.blog.service;

import net.eleword.blog.dao.ArticleSearchDao;
import net.eleword.blog.search.entity.Articles;
import net.eleword.blog.util.Pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 */
@Service
public class ArticleSearchService {

	@Autowired
	private ArticleSearchDao aritcleSearchDao;

	public  Pagination<Articles>  getAritlce(Pagination<Articles> page) {

		 return aritcleSearchDao.selectArticleIndexWithPage(page);

	}

}
