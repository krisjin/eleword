package net.eleword.blog.action;

import javax.servlet.http.HttpServletRequest;

import net.eleword.blog.entity.Color;
import net.eleword.blog.util.Pagination;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.jdbc.StringUtils;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-3-13下午12:59:29
 */
@Controller
public class MaintainColorAction extends BaseAction {

	@RequestMapping(value = "/admin/colors.htm", method = RequestMethod.GET)
	public String listColors(HttpServletRequest request) {
		Pagination<Color> page = new Pagination<Color>();
		String pageCount = request.getParameter("page");
		if (StringUtils.isNullOrEmpty(pageCount)) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(pageCount));
		}
		page.getStartPage();
		page.setPageSize(800);
		page = colorService.queryColorWithPage(page);
		request.setAttribute("pa", page);
		return "admin/listColor.htm";
	}

	@RequestMapping(value = "/admin/colors/add.htm", method = RequestMethod.GET)
	public String add() {
		return "admin/addColor.htm";
	}

	@RequestMapping(value = "/admin/colors/save.htm", method = RequestMethod.POST)
	public String addSave(
			@RequestParam(value = "code") String code, 
			@RequestParam(value = "name") String name, 
			@RequestParam(value = "description") String description,
			HttpServletRequest request) {
		Color color = new Color();
		color.setCode(code);
		color.setDescription(description);
		color.setName(name);
		Color orginColor = colorService.queryColorByCode(code);
		if (orginColor != null) {
			request.setAttribute("error", "RGB已经存在，请换一个.");
			request.setAttribute("color", color);
			return "admin/addColor.htm";
		}
		colorService.addColor(color);
		return "redirect:/admin/colors.htm";
	}

}
