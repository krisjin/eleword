package net.eleword.blog.action;

import javax.servlet.http.HttpServletRequest;

import net.eleword.blog.entity.Color;
import net.eleword.blog.service.ColorService;
import net.eleword.blog.util.Pagination;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mysql.jdbc.StringUtils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-3-13下午12:59:29
 */
@Controller("colorAction")
@Scope("prototype")
public class MaintainColorAction extends ActionSupport {

	private String name;

	private String description;

	private String code;

	@Autowired
	private ColorService colorService;

	public String list() {
		Pagination<Color> page = new Pagination<Color>();
		HttpServletRequest request = ServletActionContext.getRequest();
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
		return "list";
	}

	public String add() {
		return "add";
	}

	public String addSave() {
		HttpServletRequest request = ServletActionContext.getRequest();

		Color color = new Color();
		color.setCode(code);
		color.setDescription(description);
		color.setName(name);

		Color orginColor = colorService.queryColorByCode(code);

		if (orginColor != null) {
			request.setAttribute("error", "RGB已经存在，请换一个.");
			request.setAttribute("color", color);
			return "add";
		}
		colorService.addColor(color);
		return "returnSaveList";
	}

	public void validate() {
		
	}
	
	public String delete() {
		return "list";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
