package net.eleword.blog.dao;

import java.util.List;

import net.eleword.blog.dao.common.BaseDao;
import net.eleword.blog.entity.Folder;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 */
public interface FolderDao extends BaseDao<Folder> {

	List<Folder> selectAllFolder();

	Folder selectFolderByName(String name);
}
