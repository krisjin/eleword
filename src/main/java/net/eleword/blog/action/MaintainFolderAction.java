package net.eleword.blog.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.eleword.blog.entity.Folder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 */
@Controller
public class MaintainFolderAction extends BaseAction {

	@RequestMapping(value = "/admin/folders.htm", method = RequestMethod.GET)
	public String listFolder(HttpServletRequest request) {
		List<Folder> folderList = folderService.selectAllFolder();
		request.setAttribute("folderList", folderList);
		request.setAttribute("flag", "add");
		return "admin/listFolder.htm";
	}

	@RequestMapping(value = "/admin/folder/post.htm", method = RequestMethod.POST)
	public String save(HttpServletRequest request,
			@RequestParam(value = "fatherId", defaultValue = "0") long fatherId,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "ename") String ename, 
			@RequestParam(value = "content") String content) {
		Folder folder = new Folder();
		folder.setContent(content);
		folder.setEname(ename);
		folder.setFatherId(fatherId);
		folder.setName(name);
		folder.setStatus(1);
		folder.setCreateTime(new Date());
		folderService.addFolder(folder);
		return "redirect:/admin/folders.htm";
	}

	@RequestMapping(value = "/admin/folder/{id}.htm", method = RequestMethod.GET)
	public String update(HttpServletRequest request, @PathVariable("id") Long id) {

		Folder folder = folderService.selectFolderById(id);
		List<Folder> folderList = folderService.selectAllFolder();
		request.setAttribute("flag", "update");
		request.setAttribute("folder", folder);
		request.setAttribute("folderList", folderList);
		return "admin/listFolder.htm";
	}

	@RequestMapping(value = "/admin/folder/update.htm", method = RequestMethod.POST)
	public String updateSave(HttpServletRequest request,
			@RequestParam(value = "fatherId", defaultValue = "0") long fatherId,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "ename") String ename,
			@RequestParam(value = "content") String content,
			@RequestParam(value = "id") Long id) {

		Folder folder = new Folder();
		folder.setContent(content);
		folder.setEname(ename);
		folder.setFatherId(fatherId);
		folder.setName(name);
		folder.setStatus(1);
		folder.setUpdateTime(new Date());
		folder.setId(id);
		folderService.update(folder);
		return "redirect:/admin/folders.htm";
	}

	@RequestMapping(value = "/admin/folder/delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable("id") Long id) {
		folderService.deleteFolderById(id);
		return "redirect:/admin/folders.htm";
	}

}
