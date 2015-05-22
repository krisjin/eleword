package net.eleword.blog.dao;

import net.eleword.blog.dao.common.BaseDao;
import net.eleword.blog.entity.Folder;

import java.util.List;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin
 */
public interface FolderDao extends BaseDao<Folder> {

    List<Folder> selectAllFolder(int status);

    Folder selectFolderByName(String name);
}
