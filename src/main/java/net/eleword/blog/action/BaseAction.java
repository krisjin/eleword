package net.eleword.blog.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-2-17上午9:20:44
 */

public class BaseAction extends ActionSupport {

	public BaseAction() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

	}
}
