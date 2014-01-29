package net.eleword.blog.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.eleword.blog.entity.Article;
import net.eleword.blog.service.ArticleService;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller("indexAction")
@Scope("prototype")
public class IndexAction extends ActionSupport {
	
	@Autowired
	private ArticleService articleService;

	public String execute() {
		List<Article> articles=articleService.selectAll();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("articles", articles);
		return "index";
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

}
