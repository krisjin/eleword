package net.eleword.blog.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-5-4下午4:06:00
 */
@Controller
public class FileManage {
	String relativelyPath = "/FileStore";

	@RequestMapping(value = "/admin/files", method = RequestMethod.GET)
	public String list() {

		return "admin/fileManage.htm";
	}

	@RequestMapping(value = "/admin/file/add.htm", method = RequestMethod.GET)
	public String add() {
		return "admin/addFile.htm";
	}

	@RequestMapping(value = "/admin/file/save.htm", method = RequestMethod.POST)
	public String saveAvatar(HttpServletRequest request, @RequestParam(value = "file") CommonsMultipartFile file) {
		if (file != null) {
			try {
				@SuppressWarnings("deprecation")
				String avatarFolder = request.getRealPath("/") + relativelyPath + "/";
				File tmpFile = new File(avatarFolder);
				if (!tmpFile.exists()) {
					tmpFile.mkdirs();
				}

				File newFile = new File(avatarFolder, file.getOriginalFilename());
				file.transferTo(newFile);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return "redirect:/admin/fileManage.htm";
	}
}
