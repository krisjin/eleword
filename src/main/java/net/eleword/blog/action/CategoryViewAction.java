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
import org.springframework.stereotype.Controller;

import com.mysql.jdbc.StringUtils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-2-2上午11:17:57
 */
@Controller("viewCategoryAction")
public class CategoryViewAction extends ActionSupport {

	@Autowired
	private ArticleService articleService;
	@Autowired
	private CategoryService categoryService;

	public String execute() throws Exception {
		return "";
	}

	public String category() {

		Pagination<Article> page = new Pagination<Article>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String categoryId = request.getParameter("id");
		String pageCount = request.getParameter("page");
		String tmpCategoryName="";

		if (StringUtils.isNullOrEmpty(pageCount)) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(pageCount));
		}
		
		page = articleService.selectArticleWithPageByCategoryId(page, Long.valueOf(categoryId));
		
		List<Category> categories = categoryService.selectAll();

		List<Article> arts = page.getResultSet();
		for (Article art : arts) {
			art.setContent(HtmlUtil.subStrByte(HtmlUtil.filterHtml(art.getContent()), 400));
			for (Category category : categories) {
				if (art.getCategoryId() == category.getId()) {
					art.setCategoryName(category.getName());
					tmpCategoryName = category.getName();
				}
			}
		}
		request.setAttribute("categoryId", categoryId);
		page.setResultSet(arts);
		request.setAttribute("categories", categories);
		request.setAttribute("pa", page);
		request.setAttribute(ConstantEnum.pageTitle.toString(), tmpCategoryName+"分类的文章");
		return "cateView";
	}

}
