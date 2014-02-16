package net.eleword.blog.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.coobird.thumbnailator.Thumbnails;
import net.eleword.blog.entity.User;
import net.eleword.blog.util.MD5Util;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-2-16上午8:52:51
 */
@Controller("uploadAction")
public class UploadAction extends ActionSupport {

	private File file;
	private String relativelyPath;
	private String absolutePath;

	public String execute() {
		return "uploadAvatar";
	}

	public String avatar() {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("USER_SESSION");
		if (file != null) {
			try {
				String imgName = MD5Util.encrypt(String.valueOf(user.getId()))+".jpg";
				String fileName=request.getRealPath("/")+request.getContextPath()+relativelyPath+"/";
				System.out.println(fileName+"--------new");
				File tmpFile=new File(fileName);
				if(!tmpFile.exists()){
					tmpFile.mkdirs();
				}
				
				Thumbnails.of(file).forceSize(160, 140).outputFormat("jpg").outputQuality(0.99f).toFile(tmpFile.getAbsolutePath()+fileName);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

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
