package net.eleword.blog.dao;

import java.util.List;

import net.eleword.blog.dao.common.BaseDao;
import net.eleword.blog.entity.Media;
import net.eleword.blog.util.Pagination;

/**
 * TODO 此处填写 class 信息
 * @author krisjin (mailto:krisjin86@163.com)
 */
public interface MediaDao extends BaseDao<Media>{
	
	Pagination<Media> selectMediaWithPage(Pagination<Media> page,int status);
	
	List<Media> getAllMedia();
}

