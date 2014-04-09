package net.eleword.blog.dao.impl;

import net.eleword.blog.dao.FolderDao;
import net.eleword.blog.dao.common.HibernateDao;
import net.eleword.blog.entity.Folder;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin (mailto:krisjin86@163.com)
 */
@Repository("folderDao")
public class FolderDaoImpl extends HibernateDao<Folder, Long> implements FolderDao {

	public Long add(Folder entity) {

		return (Long) save(entity);
	}

	public void update(Folder entity) {
		saveOrUpdate(entity);
	}

	public void deleteById(long id) {
		delete(id);

	}

	public Folder select(long id) {
		return get(id);
	}

	public List<Folder> selectAllFolder() {
		String hql = "from Folder where fatherId=0 and status=1";
		return find(hql);
	}

	public Folder selectFolderByName(String name) {
		return findUniqueBy("ename", name);
	}


}
