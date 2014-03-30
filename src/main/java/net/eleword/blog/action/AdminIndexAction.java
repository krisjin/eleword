
package net.eleword.blog.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO 此处填写 class 信息
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-1-28上午5:59:48
 */
@Controller
public class AdminIndexAction{
	
	@RequestMapping(value="/admin/index")
	public String index() throws Exception {
		return "admin/main.htm";
	}

}

