package net.eleword.blog.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.eleword.blog.entity.Article;
import net.eleword.blog.entity.Category;
import net.eleword.blog.service.ArticleService;
import net.eleword.blog.service.CategoryService;
import net.eleword.blog.util.ConstantEnum;
import net.eleword.blog.util.HtmlUtil;
import net.eleword.blog.util.Pagination;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mysql.jdbc.StringUtils;
import com.opensymphony.xwork2.ActionSupport;

@Controller("indexAction")
@Scope("prototype")
public class IndexAction extends ActionSupport {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private CategoryService categoryService;

	public String execute() {
		Pagination<Article> page = new Pagination<Article>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String pageCount = request.getParameter("page");

		if (StringUtils.isNullOrEmpty(pageCount)) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(pageCount));
		}
		page.getStartPage();
		page = articleService.selectArticleWithPage(page);
		List<Category> categories = categoryService.selectAll();

		List<Article> arts = page.getResultSet();

		for (Article art : arts) {
			art.setContent(HtmlUtil.subStrByte(HtmlUtil.filterHtml(art.getContent()), 400));
			for (Category category : categories) {
				if (art.getCategoryId() == category.getId()) {
					art.setCategoryName(category.getName());
				}
			}
		}
		page.setResultSet(arts);
		request.setAttribute("categories", categories);
		request.setAttribute("pa", page);
		request.setAttribute(ConstantEnum.pageTitle.toString(),"Eleword博客" );
		return "index";
	}

	public String view() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Article article = articleService.queryById(Long.valueOf(id));
		List<Category> categories = categoryService.selectAll();

		for (Category cate : categories) {
			if (article.getCategoryId() == cate.getId()) {
				article.setCategoryName(cate.getName());
			}
		}
		request.setAttribute("categories", categories);
		request.setAttribute("article", article);
		request.setAttribute(ConstantEnum.pageTitle.toString(), article.getTitle());
		return "view";
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

}
