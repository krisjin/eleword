package net.eleword.blog.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 */
@Controller("")
@Scope("prototype")
public class BlogAction extends ActionSupport {

	public String config() {

		return "config";
	}

	public String addConfig() {

		return "success";
	}
}
