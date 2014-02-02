package net.eleword.blog.dao.impl;

import java.util.List;

import net.eleword.blog.dao.ArticleDao;
import net.eleword.blog.dao.common.HibernateDao;
import net.eleword.blog.entity.Article;
import net.eleword.blog.util.Pagination;

import org.springframework.stereotype.Repository;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-1-27上午6:25:10
 */
@Repository("articleDao")
public class ArticleDaoImpl extends HibernateDao<Article, Long> implements ArticleDao {

	public Long add(Article entity) {

		return (Long) save(entity);
	}

	public void update(Article entity) {
		saveOrUpdate(entity);
	}

	public void deleteById(long id) {
		delete(id);
	}

	public Article select(long id) {

		return get(id);
	}
	
	public List<Article> selectAll(){
		
		return getAll();
	}

	public Pagination<Article> selectArticleWithPage(Pagination<Article> page) {
		String hql="from Article art order by art.postDate desc";
		//String hql="FROM Article art,Category cate WHERE art.categoryId=cate.id ORDER BY art.postDate DESC";
		return findPage(page ,hql);
	}

	public Pagination<Article> selectArticleWithPageByCategoryId(Pagination<Article> page, long categoryId) {
		
		String hql="from Article art where art.categoryId=? order by art.postDate desc";
		return findPage(page,hql,categoryId);
	}
	
	

}
