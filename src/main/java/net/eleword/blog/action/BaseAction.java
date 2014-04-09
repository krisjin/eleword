package net.eleword.blog.action;

import net.eleword.blog.service.ArticleService;
import net.eleword.blog.service.BlogService;
import net.eleword.blog.service.CategoryService;
import net.eleword.blog.service.ColorService;
import net.eleword.blog.service.CommentService;
import net.eleword.blog.service.FolderService;
import net.eleword.blog.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-2-17上午9:20:44
 */

public class BaseAction {

	@Autowired
	public ArticleService articleService;

	@Autowired
	public CategoryService categoryService;

	@Autowired
	public CommentService commentService;

	@Autowired
	public UserService userService;

	@Autowired
	public BlogService blogService;

	@Autowired
	public FolderService folderService;
	
	@Autowired
	public ColorService colorService;

}
