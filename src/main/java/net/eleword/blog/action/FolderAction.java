package net.eleword.blog.action;

import net.eleword.blog.service.FolderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO 此处填写 class 信息
 * @author krisjin (mailto:krisjin86@163.com)
 */
@Controller
public class FolderAction {
	
	@Autowired
	private FolderService folderService;
	
	@RequestMapping(value="/admin/folder/add")
	public String addFolder(){
		
		return "admin/addFolder.htm";
	}
	
	@RequestMapping(value="/admin/folders")
	public String listFolder(){
		
		
		
		
		return "admin/listFolder.htm";
	}
	
}

