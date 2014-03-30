package net.eleword.blog.dao;

import java.util.List;

import net.eleword.blog.dao.common.BaseDao;
import net.eleword.blog.entity.Blog;

/**
 * TODO 此处填写 class 信息
 * @author krisjin (mailto:krisjin86@163.com)
 */
public interface BlogDao extends BaseDao<Blog>{
	
	public List<Blog> getAllBlogConfig();

}

