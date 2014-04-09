package net.eleword.blog.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.coobird.thumbnailator.Thumbnails;
import net.eleword.blog.entity.User;
import net.eleword.blog.util.MD5Util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-2-16上午8:52:51
 */
@Controller("uploadAction")
public class UploadAction extends BaseAction{

	private String relativelyPath="/user/avatar";

	@RequestMapping(value="/admin/avatar.htm",method=RequestMethod.GET)
	public String avatar(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute("USER_SESSION");
//		if (file != null) {
//			try {
//				String imgName = user.getId() + MD5Util.encrypt(String.valueOf(user.getId())) + ".jpg";
//				String avatarFolder = request.getRealPath("/") + relativelyPath + "/";
//				File tmpFile = new File(avatarFolder);
//				if (!tmpFile.exists()) {
//					tmpFile.mkdirs();
//				}
//				
//				File avatarFile=new File(tmpFile,imgName);
//				
//				
//				if(avatarFile.exists()){
//					avatarFile.delete();
//				}
//				
//				System.out.println(avatarFile.getAbsolutePath()+"-----");
//				Thumbnails.of(file).forceSize(120, 110).outputFormat("jpg").outputQuality(0.99f).toFile(avatarFile.getAbsoluteFile());//tmpFile.getAbsolutePath() + File.separator + imgName);
//				
//				user.setAvatar(imgName);
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//		userService.saveOrUpateUserAvatar(user);
		return "admin/uploadAvatar.htm";
	}

	
	
	@RequestMapping(value="/admin/avatar/save.htm",method=RequestMethod.POST)
	public String saveAvatar(HttpServletRequest request,@RequestParam(value="file") CommonsMultipartFile file) {
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
				File avatarFile2 =new File(tmpFile,"tmp.jpg");
				if(avatarFile.exists()){
					avatarFile.delete();
				}
				if(avatarFile2.exists()){
					avatarFile2.delete();
				}
				
				file.transferTo(avatarFile2);
				System.out.println(avatarFile.getAbsolutePath()+"-----");
				Thumbnails.of(avatarFile2).forceSize(120, 110).outputFormat("jpg").outputQuality(0.99f).toFile(avatarFile.getAbsoluteFile());//tmpFile.getAbsolutePath() + File.separator + imgName);
				user.setAvatar(imgName);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		userService.saveOrUpateUserAvatar(user);
		return "admin/uploadAvatar.htm";
	}
	
public static void main(String[] args) {
	try {
		Thumbnails.of(new File("d:/DSC_0589.JPG")).forceSize(120, 110).outputFormat("jpg").outputQuality(0.99f).toFile("d:/e.jpg");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//tmpFile.getAbsolutePath() + File.separator + imgName);
}

}
