
package net.eleword.blog.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * TODO 此处填写 class 信息
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-1-28上午6:04:50
 */
public class LoginAction extends ActionSupport{
	
	public String execute(){
		return "login";
	}
	
	public String login(){
		return "index";
	}
	
}

