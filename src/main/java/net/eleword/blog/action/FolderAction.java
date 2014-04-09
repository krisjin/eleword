package net.eleword.blog.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.eleword.blog.entity.Blog;
import net.eleword.blog.entity.Folder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 */
@Controller
public class FolderAction extends BaseAction {

	@RequestMapping(value = "/{ename}.htm", method = RequestMethod.GET)
	public String folder(@PathVariable("ename") String ename, HttpServletRequest request) {
		Folder folder = folderService.selectFolderByName(ename);

		List<Blog> blog = blogService.queryAllBlogConfig();
		List<Folder> folderList = folderService.selectAllFolder();

		if (blog.size() > 0) {
			request.setAttribute("blog", blog.get(0));
		}
		request.setAttribute("folderList", folderList);
		request.setAttribute("active", ename);
		request.setAttribute("folder", folder);
		request.setAttribute("pageTitle", folder.getName());
		return "folder/" + ename + ".htm";
	}
}
