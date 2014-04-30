package net.eleword.blog.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.eleword.blog.entity.Article;
import net.eleword.blog.entity.Blog;
import net.eleword.blog.entity.Category;
import net.eleword.blog.entity.Folder;
import net.eleword.blog.entity.User;
import net.eleword.blog.search.SearchHelper;
import net.eleword.blog.search.entity.Articles;
import net.eleword.blog.service.ArticleSearchService;
import net.eleword.blog.util.ConstantEnum;
import net.eleword.blog.util.DateUtils;
import net.eleword.blog.util.HtmlUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-4-30下午3:21:26
 */

@Controller
public class ArticleSearchAction extends BaseAction {

	@Autowired
	private ArticleSearchService aritcleSearchService;

	@RequestMapping(value = "/search.htm", method = RequestMethod.GET)
	public String search(HttpServletRequest request,
						 @RequestParam(value = "q") String q,
						 @RequestParam(value = "page",defaultValue="1") int page) {
		
		List<Articles> articles = null;
		List result=new ArrayList();
		try {
			articles = aritcleSearchService.search(q, 20, page,result);
			
			if(articles!=null && articles.size()>0){
				
				for(Articles art:articles){
					String content=HtmlUtil.subStrByte(HtmlUtil.filterHtml(art.getContent()), 300);
					art.setContent(SearchHelper.highlight(content, q));
					art.setTitle(SearchHelper.highlight(art.getTitle(), q));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Blog> blog = blogService.queryAllBlogConfig();
		List<Category> categories = categoryService.selectAll();
		List articleArchive = DateUtils.handleArticleArchiveDate(articleService.queryArticleArchive());
		User user = userService.selectUserByName(ConstantEnum.admin.toString());
		List<Article> recentArticle = articleService.selectRecnetArticle(10);
		List<Folder> folderList = folderService.selectAllFolder();
		
		if (blog.size() > 0) {
			request.setAttribute("blog", blog.get(0));
		}
		if(user!=null)
			request.setAttribute("user", user);
		
		if(result.size()>0){
			request.setAttribute("result", result.get(0));
		}
		request.setAttribute("active", "search");
		request.setAttribute("page", page);
		request.setAttribute("q", q);
		request.setAttribute("folderList", folderList);
		request.setAttribute("recentArticle", recentArticle);
		request.setAttribute("articleArchive", articleArchive);
		request.setAttribute("categories", categories);
		request.setAttribute(ConstantEnum.pageTitle.toString(), "搜索");
		request.setAttribute("articles", articles);
		return "search.htm";

	}
	
	@RequestMapping(value = "/go.htm", method = RequestMethod.GET)
	public String searchs(HttpServletRequest request){
		List<Blog> blog = blogService.queryAllBlogConfig();
		List<Category> categories = categoryService.selectAll();
		List articleArchive = DateUtils.handleArticleArchiveDate(articleService.queryArticleArchive());
		User user = userService.selectUserByName(ConstantEnum.admin.toString());
		List<Article> recentArticle = articleService.selectRecnetArticle(10);
		List<Folder> folderList = folderService.selectAllFolder();
		
		if (blog.size() > 0) {
			request.setAttribute("blog", blog.get(0));
		}
		if(user!=null)
			request.setAttribute("user", user);
		
		
		
		request.setAttribute("q", "");
		request.setAttribute("active", "search");
		request.setAttribute("folderList", folderList);
		request.setAttribute("recentArticle", recentArticle);
		request.setAttribute("articleArchive", articleArchive);
		request.setAttribute("categories", categories);
		request.setAttribute(ConstantEnum.pageTitle.toString(), "搜索");
		return "search.htm";
	}
	
}
