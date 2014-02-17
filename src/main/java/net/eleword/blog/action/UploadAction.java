package net.eleword.blog.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.coobird.thumbnailator.Thumbnails;
import net.eleword.blog.entity.User;
import net.eleword.blog.service.UserService;
import net.eleword.blog.util.MD5Util;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-2-16上午8:52:51
 */
@Controller("uploadAction")
public class UploadAction extends BaseAction {

	private File file;
	private String relativelyPath;
	private String absolutePath;

	@Autowired
	private UserService userService;

	public String execute() {
		return "uploadAvatar";
	}

	public String avatar() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("USER_SESSION");
		if (file != null) {
			try {
				String imgName = user.getId() + MD5Util.encrypt(String.valueOf(user.getId())) + ".jpg";
				String avatarFolder = request.getRealPath("/") + relativelyPath + "/";
				File tmpFile = new File(avatarFolder);
				if (!tmpFile.exists()) {
					tmpFile.mkdirs();
				}
				
				File avatarFile=new File(tmpFile,imgName);
				
				
				if(avatarFile.exists()){
					avatarFile.delete();
				}
				
				System.out.println(avatarFile.getAbsolutePath()+"-----");
				Thumbnails.of(file).forceSize(120, 110).outputFormat("jpg").outputQuality(0.99f).toFile(avatarFile.getAbsoluteFile());//tmpFile.getAbsolutePath() + File.separator + imgName);
				
				user.setAvatar(imgName);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		userService.saveOrUpateUserAvatar(user);
		return "success";
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getRelativelyPath() {
		return relativelyPath;
	}

	public void setRelativelyPath(String relativelyPath) {
		this.relativelyPath = relativelyPath;
	}

	public String getAbsolutePath() {
		return absolutePath;
	}

	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}

}
