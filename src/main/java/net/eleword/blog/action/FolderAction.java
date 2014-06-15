package net.eleword.blog.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.eleword.blog.entity.Blog;
import net.eleword.blog.entity.Folder;
import net.eleword.blog.entity.News;
import net.eleword.blog.entity.User;
import net.eleword.blog.util.ConstantEnum;
import net.eleword.blog.util.Pagination;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin 
 */
@Controller
public class FolderAction extends BaseAction {

	@RequestMapping(value = "/{ename}.htm", method = RequestMethod.GET)
	public String folder(@PathVariable(value="ename") String ename, HttpServletRequest request) {
		
		Pagination<News> newsPage = new Pagination<News>();
		Folder folder = folderService.selectFolderByName(ename);
		long folderId = folder.getId();
		Integer page=Integer.valueOf(request.getParameter("p"));
		if(page==null || page==0){
			page=1;
		}
		
		List<Blog> blog = blogService.queryAllBlogConfig();
		List<Folder> folderList = folderService.selectAllFolder(0);
		User user = userService.selectUserByName(ConstantEnum.admin.toString());
		
		
		
		//newsService.selectNewsWithPageByFolderId(page, folderId);
		if (blog.size() > 0) {
			request.setAttribute("blog", blog.get(0));
		}
		if(user!=null)
			request.setAttribute("user", user);
		request.setAttribute("folderList", folderList);
		request.setAttribute("active", ename);
		request.setAttribute("folder", folder);
		request.setAttribute("pageTitle", folder.getName());
		return "folder/" + ename + ".htm";
	}
}
