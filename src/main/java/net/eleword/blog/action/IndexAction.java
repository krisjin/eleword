package net.eleword.blog.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.eleword.blog.entity.Article;
import net.eleword.blog.entity.Blog;
import net.eleword.blog.entity.Category;
import net.eleword.blog.entity.Comment;
import net.eleword.blog.entity.User;
import net.eleword.blog.service.ArticleService;
import net.eleword.blog.service.BlogService;
import net.eleword.blog.service.CategoryService;
import net.eleword.blog.service.CommentService;
import net.eleword.blog.service.UserService;
import net.eleword.blog.util.ConstantEnum;
import net.eleword.blog.util.DateUtils;
import net.eleword.blog.util.HtmlUtil;
import net.eleword.blog.util.Pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysql.jdbc.StringUtils;

@Controller
public class IndexAction {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String listArticles(HttpServletRequest request, HttpServletResponse response) {
		Pagination<Article> page = new Pagination<Article>();
		List<Blog> blog = blogService.queryAllBlogConfig();
		String pageCount = request.getParameter("page");
		if (StringUtils.isNullOrEmpty(pageCount)) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(pageCount));
		}
		page.getStartPage();
		page = articleService.selectArticleWithPage(page);
		List<Article> recentArticle = articleService.selectRecnetArticle(10);
		
		List<Category> categories = categoryService.selectAll();

		List<Article> arts = page.getResultSet();
		for (Article art : arts) {
			art.setContent(HtmlUtil.subStrByte(HtmlUtil.filterHtml(art.getContent()),300));
			for (Category category : categories) {
				if (art.getCategoryId() == category.getId()) {
					art.setCategoryName(category.getName());
				}
			}
			art.setCommentCount(commentService.selectCommentByArticleId(art.getId()).size());
		}
		if(blog.size()>0){
			request.setAttribute("blog", blog.get(0));
		}
		
		List articleArchive = DateUtils.handleArticleArchiveDate(articleService.queryArticleArchive());
		User user = userService.selectUserByName(ConstantEnum.admin.toString());
		page.setResultSet(arts);
		request.setAttribute("recentArticle", recentArticle);
		request.setAttribute("articleArchive", articleArchive);
		request.setAttribute("categories", categories);
		request.setAttribute("pa", page);
		request.setAttribute("avatar", user.getAvatar());
		request.setAttribute(ConstantEnum.pageTitle.toString(), "Eleword博客");
		return "index.htm";
	}

	@RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
	public String view(@PathVariable("id") Long id,HttpServletRequest request) {
		Pagination<Comment> commentPage = new Pagination<Comment>();
		commentPage.setPageSize(15);
		String pageCount = request.getParameter("page");
		if (StringUtils.isNullOrEmpty(pageCount)) {
			commentPage.setCurrentPage(1);
		} else {
			commentPage.setCurrentPage(Integer.valueOf(pageCount));
		}
		commentPage.getStartPage();
		commentPage =commentService.selectCommentWithPageByArticleId(commentPage, Long.valueOf(id));
		Article article = articleService.queryById(Long.valueOf(id));
		List<Category> categories = categoryService.selectAll();
		for (Category cate : categories) {
			if (article.getCategoryId() == cate.getId()) {
				article.setCategoryName(cate.getName());
			}
		}
		User user =userService.selectUserByName(ConstantEnum.admin.toString());
		List<Blog> blog = blogService.queryAllBlogConfig();
		List articleArchive = DateUtils.handleArticleArchiveDate(articleService.queryArticleArchive());
		List<Article> recentArticle = articleService.selectRecnetArticle(10);
		
		request.setAttribute("recentArticle", recentArticle);
		request.setAttribute("articleArchive", articleArchive);
		request.setAttribute("commentCount", commentService.selectCommentByArticleId(id).size());
		request.setAttribute("blog", blog.get(0));
		request.setAttribute("avatar", user.getAvatar());
		request.setAttribute("pa", commentPage);
		request.setAttribute("categories", categories);
		request.setAttribute("article", article);
		request.setAttribute(ConstantEnum.pageTitle.toString(), article.getTitle());
		return "view.htm";

	}

	
	@RequestMapping(value="/articles/archive/{date}",method=RequestMethod.GET)
	public String artilceArchive(@PathVariable("date") String date,HttpServletRequest request) {
		String encodeDate="";
		Pagination<Article> page =new Pagination<Article>();
		String pageCount=request.getParameter("page");
		
		if(StringUtils.isNullOrEmpty(pageCount)){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.valueOf(pageCount));
		}
		page.getStartPage();
		try {
			encodeDate=URLDecoder.decode(date, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		List<Blog> blog = blogService.queryAllBlogConfig();
		articleService.selectArticleArchiveDateWithPage(page, DateUtils.handleArticleArchiveDate(encodeDate));
		List<Category> categories = categoryService.selectAll();
		List articleArchive = DateUtils.handleArticleArchiveDate(articleService.queryArticleArchive());
		User user = userService.selectUserByName(ConstantEnum.admin.toString());
		List<Article> recentArticle = articleService.selectRecnetArticle(10);
		List<Article> arts = page.getResultSet();
		
		for (Article art : arts) {
			art.setContent(HtmlUtil.subStrByte(HtmlUtil.filterHtml(art.getContent()), 400));
			for (Category category : categories) {
				if (art.getCategoryId() == category.getId()) {
					art.setCategoryName(category.getName());
				}
			}
			art.setCommentCount(commentService.selectCommentByArticleId(art.getId()).size());
		}
		if(blog.size()>0){
			request.setAttribute("blog", blog.get(0));
		}
		
		
		page.setResultSet(arts);
		request.setAttribute("recentArticle", recentArticle);
		request.setAttribute("articleArchive", articleArchive);
		request.setAttribute("categories", categories);
		request.setAttribute("pa", page);
		request.setAttribute("avatar", user.getAvatar());
		request.setAttribute(ConstantEnum.pageTitle.toString(), encodeDate+":文章归档");
		request.setAttribute("archiveDate", encodeDate);
		return "artilceArchive.htm";
	}
	
	
	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	

}
