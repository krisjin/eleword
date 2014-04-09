package net.eleword.blog.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.eleword.blog.entity.Article;
import net.eleword.blog.entity.Category;
import net.eleword.blog.entity.Folder;
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
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-2-2上午11:17:57
 */
@Controller
public class CategoryViewAction extends BaseAction {

	@RequestMapping(value = "/category/{id}.htm", method = RequestMethod.GET)
	public String category(@PathVariable("id") Long id, HttpServletRequest request) {

		Pagination<Article> page = new Pagination<Article>();
		String pageCount = request.getParameter("page");
		String tmpCategoryName = "";

		if (StringUtils.isNullOrEmpty(pageCount)) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(pageCount));
		}

		page = articleService.selectArticleWithPageByCategoryId(page, Long.valueOf(id));

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
			art.setCommentCount(commentService.selectCommentByArticleId(art.getId()).size());
		}
		page.setResultSet(arts);
		User user = userService.selectUserByName(ConstantEnum.admin.toString());
		List articleArchive = DateUtils.handleArticleArchiveDate(articleService.queryArticleArchive());
		List<Article> recentArticle = articleService.selectRecnetArticle(10);
		List<Folder> folderLlist = folderService.selectAllFolder();

		request.setAttribute("folderList", folderLlist);
		request.setAttribute("articleArchive", articleArchive);
		request.setAttribute("blog", blogService.queryAllBlogConfig().get(0));
		request.setAttribute("avatar", user.getAvatar());
		request.setAttribute("categoryId", id);
		request.setAttribute("recentArticle", recentArticle);
		request.setAttribute("categories", categories);
		request.setAttribute("pa", page);
		request.setAttribute(ConstantEnum.pageTitle.toString(), tmpCategoryName + "分类的文章");
		return "viewCategory.htm";
	}

}
