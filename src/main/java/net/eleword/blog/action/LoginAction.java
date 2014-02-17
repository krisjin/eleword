package net.eleword.blog.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.eleword.blog.entity.User;
import net.eleword.blog.service.UserService;
import net.eleword.blog.util.MD5Util;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-1-28上午6:04:50
 */
@Controller("loginAction")
public class LoginAction extends BaseAction {

	private String username;
	private String password;

	@Autowired
	private UserService userService;

	public String execute() {
		return "login";
	}

	public String login() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		User user = userService.selectUserByName(username);

		if (user == null) {
			request.setAttribute("msg", "用户名不存在!");
			request.setAttribute("username",username);
			return "failure";
		}
		if (!StringUtils.equals(user.getPassword(), MD5Util.encrypt(password))) {
			request.setAttribute("msg", "用户密码不正确!");
			request.setAttribute("username",username);
			return "failure";
		}
		
		session.setAttribute("USER_SESSION", user);
		return "success";
	}
	
	public String logout(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("USER_SESSION");
		session.removeAttribute("USER_SESSION");
    	session.invalidate();
    	return "logout";
    
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
