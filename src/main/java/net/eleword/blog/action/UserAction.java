package net.eleword.blog.action;

import javax.servlet.http.HttpServletRequest;

import net.eleword.blog.entity.User;
import net.eleword.blog.service.UserService;
import net.eleword.blog.util.ConstantEnum;
import net.eleword.blog.util.MD5Util;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mysql.jdbc.StringUtils;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction {

	private String oldPassword;
	private String newPassword;
	private String repeatNewPassword;

	@Autowired
	private UserService userService;

	public String execute() throws Exception {

		return "modifyPassword";
	}

	public String modifyPassword() {

		HttpServletRequest request = ServletActionContext.getRequest();

		User user = (User) request.getSession().getAttribute("USER_SESSION");

		if (StringUtils.isNullOrEmpty(oldPassword)) {
			request.setAttribute(ConstantEnum.msg.toString(), "旧密码不能为空!");
			return ConstantEnum.error.toString();
		}
		String encrptyOldPassword = MD5Util.encrypt(oldPassword);
		System.out.println(user.getPassword()+"---old");
		System.out.println(encrptyOldPassword+"---old2");
		if (!user.getPassword().equals(encrptyOldPassword)) {
			request.setAttribute(ConstantEnum.msg.toString(), "旧密码不正确!");
			return ConstantEnum.error.toString();
		}
		
		if (StringUtils.isNullOrEmpty(newPassword) || StringUtils.isNullOrEmpty(repeatNewPassword)) {
			request.setAttribute(ConstantEnum.msg.toString(), "新密码或重复密码不能为空!");
			return ConstantEnum.error.toString();
		}
		
		user.setPassword(MD5Util.encrypt(newPassword));
		
		userService.updatePassword(user);
		request.setAttribute(ConstantEnum.msg.toString(), "密码修改成功!");
		
		return ConstantEnum.success.toString();
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRepeatNewPassword() {
		return repeatNewPassword;
	}

	public void setRepeatNewPassword(String repeatNewPassword) {
		this.repeatNewPassword = repeatNewPassword;
	}

}
