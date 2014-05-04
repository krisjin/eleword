package net.eleword.blog.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.eleword.blog.entity.WebStatistics;
import net.eleword.blog.service.WebStatisticsService;
import net.eleword.blog.util.Pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysql.jdbc.StringUtils;

/**
 * TODO 此处填写 class 信息
 * @author krisjin (mailto:krisjin86@163.com)
 */
@Controller
public class WebStatisticsAction {
	
	@Autowired
	private WebStatisticsService webStatisticsService;
	
	
	@RequestMapping(value = "/admin/statistics.htm", method = RequestMethod.GET)
	public String list(HttpServletRequest request){
		Pagination<WebStatistics> page = new Pagination<WebStatistics>();
		String pageCount = request.getParameter("page");

		if (StringUtils.isNullOrEmpty(pageCount)) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(pageCount));
		}
		page.getStartPage();
		page = webStatisticsService.selectWebStatisticsWithPage(page);
		
		List<WebStatistics> wsList= page.getResultSet();
		
//		for(WebStatistics ws:wsList){
//				ws.setAddress(HttpUtils.getAddressFromIP(ws.getIp()));
//		}
		
		page.setResultSet(wsList);
		request.setAttribute("pa", page);
		return "admin/listWebStatistics.htm";
	}
}

