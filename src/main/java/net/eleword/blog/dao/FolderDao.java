package net.eleword.blog.dao;

import java.util.List;

import net.eleword.blog.dao.common.BaseDao;
import net.eleword.blog.entity.Folder;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin 
 */
public interface FolderDao extends BaseDao<Folder> {

	List<Folder> selectAllFolder(int status);

	Folder selectFolderByName(String name);
}
