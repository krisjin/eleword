package net.eleword.blog.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.eleword.blog.entity.Article;
import net.eleword.blog.service.ArticleService;
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

	public String execute() {
		
		Pagination<Article> page =new Pagination<Article>();
		
		
		
		HttpServletRequest request=ServletActionContext.getRequest();
		String pageCount=request.getParameter("page");
		
		if(StringUtils.isNullOrEmpty(pageCount)){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.valueOf(pageCount));
		}
		page.getStartPage();
		page=articleService.selectArticleWithPage(page);
		
		request.setAttribute("pa", page);
		return "index";
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

}
