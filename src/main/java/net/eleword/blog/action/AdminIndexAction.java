
package net.eleword.blog.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * TODO 此处填写 class 信息
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-1-28上午5:59:48
 */
@Controller("adminIndexAction")
@Scope("prototype")
public class AdminIndexAction extends ActionSupport{

	public String execute() throws Exception {
		return "adminIndex";
	}

}

