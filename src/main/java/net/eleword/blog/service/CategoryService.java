package net.eleword.blog.service;

import net.eleword.blog.dao.CategoryDao;
import net.eleword.blog.entity.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO 此处填写 class 信息
 * @author krisjin (mailto:krisjin86@163.com)
 * @date  2014-1-27上午10:13:09
 */
@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	public long add(Category category){
		return categoryDao.add(category);
	}
	
}

