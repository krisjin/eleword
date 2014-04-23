package net.eleword.blog.dao.impl;

import net.eleword.blog.dao.MediaDao;
import net.eleword.blog.dao.common.HibernateDao;
import net.eleword.blog.entity.Media;
import net.eleword.blog.util.Pagination;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 */
public class MediaDaoImpl extends HibernateDao<Media, Long> implements MediaDao {

	public Long add(Media entity) {

		return (Long) save(entity);
	}

	public void update(Media entity) {
		saveOrUpdate(entity);
	}

	public void deleteById(long id) {
		delete(id);
	}

	public Media select(long id) {
		select(id);
		return null;
	}

	public Pagination<Media> selectMediaWithPage(Pagination<Media> page) {
		String hql = "from Media m  where n.status =1 order by n.createDate desc";
		return findPage(page, hql);
	}

}
