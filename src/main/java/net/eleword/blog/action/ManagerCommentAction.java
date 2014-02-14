
package net.eleword.blog.action;

import javax.servlet.http.HttpServletRequest;

import net.eleword.blog.service.CommentService;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * TODO 此处填写 class 信息
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-2-14上午7:18:22
 */
@Controller("managerCommentAction")
public class ManagerCommentAction extends ActionSupport{
	@Autowired
	private CommentService commentService;
	
	public String delete() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id=request.getParameter("id");
		commentService.deleteById(Long.valueOf(id));
		return "comtList";
	}
	
	public String execute(){
		
		return "d";
	}
	
}

