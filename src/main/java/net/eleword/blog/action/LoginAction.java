package net.eleword.blog.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.eleword.blog.entity.User;
import net.eleword.blog.util.ConstantEnum;
import net.eleword.blog.util.MD5Util;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin 
 * @date 2014-1-28上午6:04:50
 */
@Controller
public class LoginAction extends BaseAction {

	@RequestMapping(value = "/admin/login.htm", method = RequestMethod.GET)
	public String loginPage() {

		return "admin/login.htm";
	}

	@RequestMapping(value = "/admin/signin.htm", method = RequestMethod.POST)
	public String login(
			@RequestParam(value = "username") String username, 
			@RequestParam(value = "password") String password,
			HttpServletRequest request
	) {
		HttpSession session = request.getSession();
		User user = userService.selectUserByName(username);
		if (user == null) {
			request.setAttribute("msg", "用户名不存在!");
			request.setAttribute("username", username);
			return "admin/login.htm";
		}
		if (!StringUtils.equals(user.getPassword(), MD5Util.encrypt(password))) {
			request.setAttribute("msg", "用户密码不正确!");
			request.setAttribute("username", username);
			return "admin/login.htm";
		}
		
		
		
		session.setAttribute(ConstantEnum.USER_SESSION.toString(), user);
		return "admin/main.htm";
	}

	@RequestMapping(value = "/admin/logout.htm", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("USER_SESSION");
		session.removeAttribute("USER_SESSION");
		session.invalidate();
		return "redirect:/index.htm";

	}

}
