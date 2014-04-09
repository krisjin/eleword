package net.eleword.blog.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.eleword.blog.entity.Article;
import net.eleword.blog.entity.Category;
import net.eleword.blog.entity.User;
import net.eleword.blog.util.ConstantEnum;
import net.eleword.blog.util.Pagination;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.jdbc.StringUtils;

/**
 * 文章维护
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-1-29上午6:28:53
 */
@Controller
public class ArticleAction extends BaseAction {

	@RequestMapping(value = "/admin/articles.htm", method = RequestMethod.GET)
	public String listArticles(HttpServletRequest request) {
		Pagination<Article> page = new Pagination<Article>();
		String pageCount = request.getParameter("page");

		if (StringUtils.isNullOrEmpty(pageCount)) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(pageCount));
		}
		page.getStartPage();
		page = articleService.selectArticleWithPage(page);

		request.setAttribute("pa", page);
		return "admin/listArticle.htm";
	}

	@RequestMapping(value = "/admin/article/add.htm", method = RequestMethod.GET)
	public String add(HttpServletRequest request) {
		List<Category> categories = categoryService.selectAll();
		request.setAttribute("categories", categories);
		request.setAttribute("actionName", "add");
		return "admin/addArticle.htm";
	}

	@RequestMapping(value = "/admin/article/save.htm", method = RequestMethod.POST)
	public String addSave(@RequestParam(value = "content") String content, @RequestParam(value = "title") String title, @RequestParam(value = "categoryId") Long categoryId,
			HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(ConstantEnum.USER_SESSION.toString());
		Article article = new Article();

		article.setAuthor(user.getUsername());
		article.setContent(content);
		article.setCategoryId(Long.valueOf(categoryId));
		article.setTitle(title);
		article.setPostDate(new Date());
		article.setComments(null);

		Category category = categoryService.selectCategoryById(categoryId);
		articleService.addArticle(article);
		category.setArticleNumber(category.getArticleNumber() + 1);
		categoryService.updateArticleNumber(category);
		return "redirect:/admin/articles.htm";
	}

	@RequestMapping(value = "/admin/article/{id}.htm")
	public String update(@PathVariable("id") Long id,
	// @RequestParam(value="id") Long id,
			HttpServletRequest request) {
		Article article = articleService.queryById(Long.valueOf(id));
		List<Category> categories = categoryService.selectAll();
		request.setAttribute("categories", categories);
		request.setAttribute("article", article);
		request.setAttribute("actionName", "update");
		return "admin/addArticle.htm";
	}

	@RequestMapping(value = "/admin/article/usave.htm", method = RequestMethod.POST)
	public String updateSave(@RequestParam(value = "id") Long id, @RequestParam(value = "content") String content, @RequestParam(value = "title") String title,
			@RequestParam(value = "categoryId") Long categoryId, @RequestParam(value = "rawCategoryId") Long rawCategoryId, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(ConstantEnum.USER_SESSION.toString());
		Article article = new Article();
		article.setAuthor(user.getUsername());
		article.setContent(content);
		article.setCategoryId(Long.valueOf(categoryId));
		article.setModifyDate(new Date());
		article.setTitle(title);
		article.setId(id);
		articleService.updateById(article);

		if (rawCategoryId != categoryId) {
			Category rawCategory = categoryService.selectCategoryById(rawCategoryId);
			Category newCategory = categoryService.selectCategoryById(categoryId);
			if (rawCategory.getArticleNumber() > 0) {
				rawCategory.setArticleNumber(rawCategory.getArticleNumber() - 1);
				categoryService.updateArticleNumber(rawCategory);
			}
			newCategory.setArticleNumber(newCategory.getArticleNumber() + 1);
			categoryService.updateArticleNumber(newCategory);
		}
		return "redirect:/admin/articles.htm";
	}

	@RequestMapping(value = "/admin/article/delete/{id}/{categoryId}.htm", method = RequestMethod.POST)
	public String delete(@PathVariable("id") Long id, @PathVariable("categoryId") Long categoryId) {
		articleService.deleteById(Long.valueOf(id));
		Category category = categoryService.selectCategoryById(categoryId);

		if (category.getArticleNumber() > 0) {
			category.setArticleNumber(category.getArticleNumber() - 1);
			categoryService.updateArticleNumber(category);
		}

		return "redirect:/admin/articles.htm";
	}

}
