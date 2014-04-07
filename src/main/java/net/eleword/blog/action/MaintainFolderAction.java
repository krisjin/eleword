package net.eleword.blog.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.eleword.blog.entity.Folder;
import net.eleword.blog.service.FolderService;

import org.springframework.beans.factory.annotation.Autowired;
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
public class MaintainFolderAction {
	
	@Autowired
	private FolderService folderService;
	
	@RequestMapping(value = "/admin/folders", method = RequestMethod.GET)
	public String listFolder(HttpServletRequest request) {
		List<Folder> folderList = folderService.selectAllFolder();
		request.setAttribute("folderList", folderList);	
		request.setAttribute("flag", "add");
		return "admin/listFolder.htm";
	}
	
	@RequestMapping(value = "/admin/folder/post", method = RequestMethod.POST)
	public String save(HttpServletRequest request,
					   @RequestParam(value = "fatherId", defaultValue = "0") long fatherId,
					   @RequestParam(value = "name") String name,
					   @RequestParam(value = "ename") String ename,
					   @RequestParam(value="content") String content
			){
		Folder folder = new Folder();
		folder.setContent(content);
		folder.setEname(ename);
		folder.setFatherId(fatherId);
		folder.setName(name);
		folder.setStatus(1);
		folder.setCreateTime(new Date());
		folderService.addFolder(folder);
		return "redirect:/admin/folders";
	}
	
	@RequestMapping(value = "/admin/folder/{id}", method = RequestMethod.GET)
	public String update(HttpServletRequest request,
					  	 @PathVariable("id") Long id){
		
		Folder folder = folderService.selectFolderById(id);
		List<Folder> folderList = folderService.selectAllFolder();
		request.setAttribute("flag", "update");
		request.setAttribute("folder", folder);
		request.setAttribute("folderList", folderList);	
		return "admin/listFolder.htm";
	}

	@RequestMapping(value = "/admin/folder/update", method = RequestMethod.POST)
	public String updateSave(HttpServletRequest request,
					   @RequestParam(value = "fatherId", defaultValue = "0") long fatherId,
					   @RequestParam(value = "name") String name,
					   @RequestParam(value = "ename") String ename,
					   @RequestParam(value="content") String content,
					   @RequestParam(value="id") Long id
			){
		
		Folder folder = new Folder();
		folder.setContent(content);
		folder.setEname(ename);
		folder.setFatherId(fatherId);
		folder.setName(name);
		folder.setStatus(1);
		folder.setUpdateTime(new Date());
		folder.setId(id);
		folderService.update(folder);
		return "redirect:/admin/folders";
	}
//	@ResponseBody
//	@RequestMapping(value = "/update.json", method = RequestMethod.POST)
//	public JsonVo<String> updateFolder(@RequestParam(value = "folderId") long folderId, @RequestParam(value = "name") String name, @RequestParam(value = "ename") String ename,
//			@RequestParam(value = "content", required = false) String content, @RequestParam(value = "status") FolderConstant.Status status,
//			@RequestParam(value = "type", defaultValue = "all") FolderConstant.Type type) {
//
//		JsonVo<String> json = new JsonVo<String>();
//		// FIXME 检查目录的ename不能用循环遍历检查
//		List<FolderVo> list = folderService.getAllFolderList(0, null);
//		try {
//			if (name.equals("")) {
//				json.getErrors().put("name", "目录名称不能为空");
//			}
//			if (ename.equals("")) {
//				json.getErrors().put("ename", "英文名称不能为空");
//			} else {
//				for (Folder folder : list) {
//					if (folderId != folder.getFolderId()) {
//						if (ename.equals(folder.getEname())) {
//							json.getErrors().put("folderEname", "英文名称不能重复");
//						}
//					}
//				}
//			}
//
//			// 检测校验结果
//			validate(json);
//			String newEname = ename.toLowerCase();
//			folderService.updateFolderById(folderId, newEname, name, status, content, type);
//
//			json.setResult(true);
//		} catch (Exception e) {
//			json.setResult(false);
//			json.setMsg(e.getMessage());
//		}
//		return json;
//	}

//	/**
//	 * @author 目录排序
//	 * 
//	 */
//	@ResponseBody
//	@RequestMapping(value = "/sort.json", method = RequestMethod.POST)
//	public JsonVo<String> delete(@RequestParam(value = "sortJson") String sortJson) {
//		JsonVo<String> json = new JsonVo<String>();
//		JSONArray array = JSONArray.fromObject(sortJson);
//		for (int i = 0; i < array.size(); i++) {
//			JSONObject folder = array.getJSONObject(i);
//			String folderId = folder.get("folderId").toString();
//			String sort = folder.get("sort").toString();
//			folderService.updateSort(Long.parseLong(folderId), Integer.parseInt(sort));
//		}
//		json.setResult(true);
//		return json;
//	}

	/**
	 * @author 删除目录
	 * @throws FolderNotFoundException
	 * 
	 */
//	@ResponseBody
//	@RequestMapping(value = "/delete.json", method = RequestMethod.POST)
//	public JsonVo<String> delete(@RequestParam(value = "folderId") long folderId) throws FolderNotFoundException {
//		JsonVo<String> json = new JsonVo<String>();
//		List<FolderVo> folderList = folderService.getFolderListByFatherId(folderId, null);
//		FolderVo folder = folderService.getFolderById(folderId);
//		if (folder.getOwner().equals(FolderConstant.Owner.system)) {
//			json.setResult(false);
//			json.setMsg("此目录是系统目录，无法删除！");
//		} else {
//			if (folderList.size() == 0) {
//				int count = articleService.getArticleCountByFoderId(folder.getFirstFolderId(), folder.getSecondFolderId(), folder.getThirdFolderId(), folder.getFourthFolderId());
//				if (count != 0) {
//					json.setResult(false);
//					json.setMsg("此目录下还有文件,不能被删除。");
//				} else {
//					json.setResult(true);
//					folderService.deleteFolderById(folderId);
//				}
//			} else {
//				json.setResult(false);
//				json.setMsg("此目录下有子目录，不能删除。");
//			}
//		}
//		return json;
//	}
}
