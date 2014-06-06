package net.eleword.blog.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin 
 * @date 2014-1-28上午5:59:48
 */
@Controller
public class AdminIndexAction {

	@RequestMapping(value = "/admin/index.htm", method = RequestMethod.GET)
	public String index() throws Exception {
		return "admin/main.htm";
	}
}
