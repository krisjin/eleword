package net.eleword.blog.service;

import net.eleword.blog.dao.BlogDao;
import net.eleword.blog.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin (mailto:krisjin86@163.com)
 */
@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;

	public void saveOrUpdate(Blog blog) {
		blogDao.update(blog);
	}

	public Blog queryBlogById(Long id) {
		return blogDao.select(id);
	}

	public List<Blog> queryAllBlogConfig() {
		return blogDao.getAllBlogConfig();
	}
}

