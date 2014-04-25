package net.eleword.blog.dao.impl;

import org.springframework.stereotype.Repository;

import net.eleword.blog.dao.NewsDao;
import net.eleword.blog.dao.common.HibernateDao;
import net.eleword.blog.entity.News;
import net.eleword.blog.util.Pagination;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 */
@Repository("newsDao")
public class NewsDaoImpl extends HibernateDao<News,Long> implements NewsDao {

	public Long add(News entity) {

		return (Long) save(entity);
	}

	public void update(News entity) {
		saveOrUpdate(entity);
	}

	public void deleteById(long id) {
		delete(id);
	}

	public News select(long id) {
		
		return get(id);
	}

	public Pagination<News> selectNewsWithPage(Pagination<News> page ,int status) {
		
		String hql="";

		if(status==3){
			hql = "from News n  order by n.postDate desc";
		}else{
			
			hql = "from News n  where n.status="+status+" order by n.postDate desc";
		}
		
		return findPage(page, hql);
	}

}
