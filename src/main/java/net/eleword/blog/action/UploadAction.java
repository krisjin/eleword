package net.eleword.blog.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.eleword.blog.entity.User;
import net.eleword.blog.util.MD5Util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.mortennobel.imagescaling.AdvancedResizeOp;
import com.mortennobel.imagescaling.ResampleOp;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin 
 * @date 2014-2-16上午8:52:51
 */
@Controller("uploadAction")
public class UploadAction extends BaseAction {

	private String relativelyPath = "/user/avatar";

	@RequestMapping(value = "/admin/avatar.htm", method = RequestMethod.GET)
	public String avatar(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("USER_SESSION");
		if(user!=null)
			request.setAttribute("user", user);
		return "admin/uploadAvatar.htm";
	}

	@RequestMapping(value = "/admin/avatar/save.htm", method = RequestMethod.POST)
	public String saveAvatar(HttpServletRequest request, @RequestParam(value = "file") CommonsMultipartFile file) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("USER_SESSION");
		if (file != null) {
			try {
				String imgName = user.getId() + MD5Util.encrypt(String.valueOf(user.getId())) + ".jpg";
				@SuppressWarnings("deprecation")
				String avatarFolder = request.getRealPath("/") + relativelyPath + "/";
				File tmpFile = new File(avatarFolder);
				if (!tmpFile.exists()) {
					tmpFile.mkdirs();
				}
				File avatarFile = new File(tmpFile, imgName);
				if (avatarFile.exists()) {
					avatarFile.delete();
				}
				BufferedImage src = ImageIO.read(file.getInputStream());
				ResampleOp resampleOp = new ResampleOp(150, 150);
				resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.VerySharp);
				BufferedImage rescaled = resampleOp.filter(src, null);

				ImageIO.write(rescaled, "JPG", avatarFile);																																	// +
				user.setAvatar(imgName);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		userService.saveOrUpateUserAvatar(user);
		return "redirect:/admin/avatar.htm";
	}
}
