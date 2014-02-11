package net.eleword.blog.action;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-1-28上午6:04:50
 */
@Controller("loginAction")
public class LoginAction extends ActionSupport {

	private String username;
	private String password;

	public String execute() {
		return "login";
	}

	public String login() {
		System.out.println(username + ":" + password);
		return "redirect";
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

}
