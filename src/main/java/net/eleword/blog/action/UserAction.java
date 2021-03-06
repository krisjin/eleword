package net.eleword.blog.action;

import com.mysql.jdbc.StringUtils;
import net.eleword.blog.entity.User;
import net.eleword.blog.util.ConstantEnum;
import net.eleword.blog.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserAction extends BaseAction {

    @RequestMapping(value = "/admin/password.htm", method = RequestMethod.GET)
    public String execute() throws Exception {
        return "admin/modifyPassword.htm";
    }

    @RequestMapping(value = "/admin/password/modify.htm", method = RequestMethod.POST)
    public String modifyPassword(
            @RequestParam(value = "oldPassword") String oldPassword,
            @RequestParam(value = "newPassword") String newPassword,
            @RequestParam(value = "repeatNewPassword") String repeatNewPassword,
            HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("USER_SESSION");

        if (StringUtils.isNullOrEmpty(oldPassword)) {
            request.setAttribute(ConstantEnum.msg.toString(), "旧密码不能为空!");
            return ConstantEnum.error.toString();
        }
        String encrptyOldPassword = MD5Util.encrypt(oldPassword);
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
        return "admin/modifyPassword.htm";
    }

}
