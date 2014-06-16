package net.eleword.blog.action.front;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.eleword.blog.action.BaseAction;
import net.eleword.blog.entity.Article;
import net.eleword.blog.entity.Blog;
import net.eleword.blog.entity.Category;
import net.eleword.blog.entity.Folder;
import net.eleword.blog.entity.News;
import net.eleword.blog.entity.User;
import net.eleword.blog.util.ConstantEnum;
import net.eleword.blog.util.DateUtils;
import net.eleword.blog.util.HtmlUtil;
import net.eleword.blog.util.Pagination;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysql.jdbc.StringUtils;

/**
 * TODO 此处填写 class 信息
 * @author krisjin 
 */
@Controller
public class NewsFrontAction extends BaseAction {

	@RequestMapping(value = "/channel/{folderName}.htm", method = RequestMethod.GET)
	public String listArticles(@PathVariable("folderName") String folderName,HttpServletRequest request) {
		Pagination<News> page = new Pagination<News>();
		String pageCount = request.getParameter("page");
			
		Folder folder =  folderService.selectFolderByName(folderName);
		if (StringUtils.isNullOrEmpty(pageCount)) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(pageCount));
		}
		page.getStartPage();
		page = newsService.selectNewsWithPageByFolderId(page, folder.getId());

		List<News> newsList = page.getResultSet();

		for (News news : newsList) {
			news.setContent(HtmlUtil.subStrByte(HtmlUtil.filterHtml(news.getContent()), 250));
		}
		

		page.setResultSet(newsList);
		
		List<Blog> blog = this.blogService.queryAllBlogConfig();
		List<Article> recentArticle = articleService.selectRecnetArticle(20);
		List<Category> categories = categoryService.selectAll();
		List articleArchive = DateUtils.handleArticleArchiveDate(articleService.queryArticleArchive());
		List<Folder> folderList = folderService.selectAllFolder(1);
		User user = userService.selectUserByName(ConstantEnum.admin.toString());

		if (user != null)
			request.setAttribute("user", user);

		if (blog.size() > 0) {
			request.setAttribute("blog", blog.get(0));
		}

		request.setAttribute("active", folderName);
		request.setAttribute("folderList", folderList);
		request.setAttribute("recentArticle", recentArticle);
		request.setAttribute("articleArchive", articleArchive);
		request.setAttribute("categories", categories);
		request.setAttribute(ConstantEnum.pageTitle.toString(), folder.getName()+"—Eleword博客");
		request.setAttribute("pa", page);
		return "news.htm";
	}
	
	@RequestMapping(value = "/channel/{name}/{id}.htm", method = RequestMethod.GET)
	public String getNews(@PathVariable("id") Long id,@PathVariable("name") String name,HttpServletRequest request){
		News news = newsService.getNews(id);
		
		List<Blog> blog = this.blogService.queryAllBlogConfig();
		List<Article> recentArticle = articleService.selectRecnetArticle(20);
		List<Category> categories = categoryService.selectAll();
		List articleArchive = DateUtils.handleArticleArchiveDate(articleService.queryArticleArchive());
		List<Folder> folderList = folderService.selectAllFolder(1);
		User user = userService.selectUserByName(ConstantEnum.admin.toString());

		if (user != null)
			request.setAttribute("user", user);

		if (blog.size() > 0) {
			request.setAttribute("blog", blog.get(0));
		}

		request.setAttribute("active", name);
		request.setAttribute("folderList", folderList);
		request.setAttribute("recentArticle", recentArticle);
		request.setAttribute("articleArchive", articleArchive);
		request.setAttribute("categories", categories);
		request.setAttribute(ConstantEnum.pageTitle.toString(), news.getTitle()+"—Eleword博客");
		
		
		request.setAttribute("news", news);
		return "viewNews.htm";
	}

}
