package net.eleword.blog.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport{

	private static final long serialVersionUID = 5916652293956131446L;
	private String userName;
	public String login(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("username", "shijingui");
		return "prelogin";
	}
	public String execute() throws Exception {
		return "prelogin";
	}
	
	
	
}
