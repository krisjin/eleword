package net.eleword.blog.action;

import net.eleword.blog.entity.Article;
import net.eleword.blog.entity.Blog;
import net.eleword.blog.entity.Category;
import net.eleword.blog.entity.Folder;
import net.eleword.blog.service.*;
import net.eleword.blog.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin (mailto:krisjin86@163.com)
 */
@Controller
public class FolderAction {

	@Autowired
	private FolderService folderService;

	@Autowired
	private BlogService blogService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ArticleService articleService;

	@Autowired
	private UserService userService;


	@RequestMapping(value = "/{ename}", method = RequestMethod.GET)
	public String folder(@PathVariable("ename") String ename, HttpServletRequest request) {
		Folder folder = folderService.selectFolderByName(ename);

		List<Category> categories = categoryService.selectAll();
		List<Article> recentArticle = articleService.selectRecnetArticle(10);
		List articleArchive = DateUtils.handleArticleArchiveDate(articleService.queryArticleArchive());
		List<Blog> blog = blogService.queryAllBlogConfig();
		List<Folder> folderList = folderService.selectAllFolder();

		if (blog.size() > 0) {
			request.setAttribute("blog", blog.get(0));
		}

		request.setAttribute("folderList", folderList);
		request.setAttribute("recentArticle", recentArticle);
		request.setAttribute("articleArchive", articleArchive);
		request.setAttribute("categories", categories);
		request.setAttribute("folder", folder);
		request.setAttribute("pageTitle", folder.getName());
		return "folder/" + ename + ".htm";
	}
}

