package net.eleword.blog.service;

import net.eleword.blog.dao.NewsDao;
import net.eleword.blog.entity.News;
import net.eleword.blog.util.Pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO 此处填写 class 信息
 * @author krisjin (mailto:krisjin86@163.com)
 */
@Service
public class NewsService {
	@Autowired
	private NewsDao newsDao;
	
	public void saveNews(News entity){
		newsDao.add(entity);
	}
	
	public void deleteNews(long id){
		newsDao.deleteById(id);
	}
	
	public void updateNews(News entity){
		newsDao.update(entity);
	}
	
	public News getNews(long id){
		return newsDao.select(id);
	}
	
	public  Pagination<News> selectNewsWithPage(Pagination<News> page){
		
		return newsDao.selectNewsWithPage(page);
	}
}

