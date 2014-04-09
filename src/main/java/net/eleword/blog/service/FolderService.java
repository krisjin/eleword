package net.eleword.blog.service;

import java.util.List;

import net.eleword.blog.dao.FolderDao;
import net.eleword.blog.entity.Folder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 */
@Service
public class FolderService {

	@Autowired
	private FolderDao folderDao;

	public List<Folder> selectAllFolder() {
		return folderDao.selectAllFolder();
	}

	public void addFolder(Folder folder) {
		folderDao.add(folder);
	}

	public Folder selectFolderByName(String name) {
		return folderDao.selectFolderByName(name);
	}

	public Folder selectFolderById(Long id) {
		return folderDao.select(id);
	}

	public void update(Folder folder) {
		folderDao.update(folder);
	}

	public void deleteFolderById(Long id) {
		folderDao.deleteById(id);
	}

}
