package net.eleword.blog.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.eleword.blog.entity.Media;
import net.eleword.blog.entity.News;
import net.eleword.blog.service.MediaService;
import net.eleword.blog.service.NewsService;
import net.eleword.blog.util.Pagination;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 */
@Controller
public class NewsAction {

	@Autowired
	private NewsService newsService;
	@Autowired
	private MediaService mediaService;
	
	
	@RequestMapping(value = "/admin/news.htm", method = RequestMethod.GET)
	public String list(HttpServletRequest request) {
		Pagination<News> page = new Pagination<News>();
		String pageCount = request.getParameter("page");

		if (StringUtils.isEmpty(pageCount) || pageCount==null) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(pageCount));
		}
		page.getStartPage();
		page = newsService.selectNewsWithPage(page);
		
		List<Media> medias = mediaService.getAllMedia();
		
		
		request.setAttribute("pa", page);
		request.setAttribute("medias", medias);
		request.setAttribute("flag", "query");
		return "admin/listNews.htm";
	}
	
	@RequestMapping(value = "/admin/news/add.htm", method = RequestMethod.GET)
	public String add(){
		
		return "admin/addNews.htm";
	}
	
	
}
