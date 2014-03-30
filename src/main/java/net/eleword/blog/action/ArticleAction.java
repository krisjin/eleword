package net.eleword.blog.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.eleword.blog.entity.Article;
import net.eleword.blog.entity.Category;
import net.eleword.blog.service.ArticleService;
import net.eleword.blog.service.CategoryService;
import net.eleword.blog.util.Pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.jdbc.StringUtils;

/**
 * 文章维护
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-1-29上午6:28:53
 */
@Controller
public class ArticleAction {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value="/admin/articles",method=RequestMethod.GET)
	public String listArticles(HttpServletRequest request) {
		Pagination<Article> page =new Pagination<Article>();
		String pageCount=request.getParameter("page");
		
		if(StringUtils.isNullOrEmpty(pageCount)){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.valueOf(pageCount));
		}
		page.getStartPage();
		page=articleService.selectArticleWithPage(page);
		
		request.setAttribute("pa", page);
		return "admin/listArticle.htm";
	}
	
	@RequestMapping(value="/admin/article/add",method=RequestMethod.GET)
	public String add(HttpServletRequest request) {
		List<Category> categories = categoryService.selectAll();
		request.setAttribute("categories", categories);
		request.setAttribute("actionName", "add");
		return "admin/addArticle.htm";
	}
	@RequestMapping(value="/admin/article/save",method=RequestMethod.POST)
	public String addSave(
			@RequestParam(value="content") String content,
			@RequestParam(value="title") String title,
			@RequestParam(value="categoryId") Long categoryId,
			HttpServletRequest request
			) {
		Article article = new Article();
		article.setAuthor("zhagnsan");
		article.setContent(content);
		article.setCategoryId(Long.valueOf(categoryId));
		article.setTitle(title);
		article.setPostDate(new Date());
		
		articleService.addArticle(article);
		
		return "redirect:/admin/article/add";
	}
	@RequestMapping(value="/admin/article/{id}")
	public String update(
			@PathVariable("id") Long id,
			//@RequestParam(value="id") Long id,
			HttpServletRequest request) {
		Article article=articleService.queryById(Long.valueOf(id));
		List<Category> categories = categoryService.selectAll();
		request.setAttribute("categories", categories);
		request.setAttribute("article", article);	
		request.setAttribute("actionName", "update");
		return "admin/addArticle.htm";
	}

	@RequestMapping(value="/admin/article/usave",method=RequestMethod.POST)
	public String updateSave(
			@RequestParam(value="id") Long id,
//			@PathVariable("id") Long id,
			@RequestParam(value="content") String content,
			@RequestParam(value="title") String title,
			@RequestParam(value="categoryId") Long categoryId,
			HttpServletRequest request
			) {
		Article article = new Article();
		article.setAuthor("zhagnsan");
		article.setContent(content);
		article.setCategoryId(Long.valueOf(categoryId));
		article.setModifyDate(new Date());
		article.setTitle(title);
		article.setId(id);
		articleService.updateById(article);

		return "redirect:/admin/articles";
	}

	@RequestMapping(value="/admin/article/delete/{id}",method=RequestMethod.POST)
	public String delete(@PathVariable("id") Long id) {
		articleService.deleteById(Long.valueOf(id));
		return "redirect:/admin/articles";
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


}
