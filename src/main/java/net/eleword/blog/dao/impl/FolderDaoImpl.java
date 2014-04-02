package net.eleword.blog.dao.impl;

import org.springframework.stereotype.Repository;

import net.eleword.blog.dao.FolderDao;
import net.eleword.blog.dao.common.HibernateDao;
import net.eleword.blog.entity.Folder;

/**
 * TODO 此处填写 class 信息
 * @author krisjin (mailto:krisjin86@163.com)
 */
@Repository("folderDao")
public class FolderDaoImpl extends HibernateDao<Folder,Long> implements FolderDao{

	public Long add(Folder entity) {
		
		return (Long)save(entity);
	}

	public void update(Folder entity) {
		saveOrUpdate(entity);
		
	}

	public void deleteById(long id) {
		delete(id);
		
	}

	public Folder select(long id) {
		
		return get(id);
	}}

