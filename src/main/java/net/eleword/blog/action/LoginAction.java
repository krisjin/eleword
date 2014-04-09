package net.eleword.blog.action;

import net.eleword.blog.entity.User;
import net.eleword.blog.service.UserService;
import net.eleword.blog.util.ConstantEnum;
import net.eleword.blog.util.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * TODO 此处填写 class 信息
 *
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-1-28上午6:04:50
 */
@Controller
public class LoginAction {

	private String username;
	private String password;

	@Autowired
	private UserService userService;

	public String execute() {
		return "login";
	}

	@RequestMapping(value = "/admin/login", method = RequestMethod.GET)
	public String loginPage() {

		return "admin/login.htm";
	}


	@RequestMapping(value = "/admin/loging", method = RequestMethod.POST)
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
		return "redirect:/admin/index";
	}

	@RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("USER_SESSION");
		session.removeAttribute("USER_SESSION");
		session.invalidate();
		return "redirect:/index";

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
