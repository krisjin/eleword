package net.eleword.blog.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.eleword.blog.entity.Article;
import net.eleword.blog.entity.Category;
import net.eleword.blog.service.ArticleService;
import net.eleword.blog.service.CategoryService;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-1-29上午6:28:53
 */
@Controller("articleAction")
@Scope("prototype")
public class ArticleAction extends ActionSupport {
	private String content;
	private String title;
	private String categoryId;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ArticleService articleService;

	public String execute() {

		return "list";
	}

	public String add() {
		List<Category> categories = categoryService.selectAll();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("categories", categories);
		return "add";
	}

	public String addSave() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Article article = new Article();
		article.setAuthor("zhagnsan");
		article.setContent(content);
		article.setCategoryId(Long.valueOf(categoryId));
		article.setTitle(title);
		article.setPostDate(new Date());
		
		articleService.addArticle(article);
		
		return "add";
	}

	public String update() {

		return "update";
	}

	public String udpateSave() {

		return "list";
	}

	public String delete() {

		return "list";
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

}
