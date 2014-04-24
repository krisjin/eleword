package net.eleword.blog.service;

import java.util.List;

import net.eleword.blog.dao.MediaDao;
import net.eleword.blog.entity.Media;
import net.eleword.blog.util.Pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-4-24上午9:35:55
 */
@Service
public class MediaService {

	@Autowired
	private MediaDao mediaDao;

	public void addMedia(Media entity) {

		mediaDao.add(entity);
	}

	public void deleteMedia(Long id) {
		mediaDao.deleteById(id);
	}

	public void updateMedia(Media entity) {
		mediaDao.update(entity);
	}

	public Media selectMedia(Long id) {
		return mediaDao.select(id);
	}

	public Pagination<Media> selectMediaWithPage(Pagination<Media> page ,int status) {

		return mediaDao.selectMediaWithPage(page,status);
	}

	public List<Media> getAllMedia() {

		return mediaDao.getAllMedia();
	}
}
