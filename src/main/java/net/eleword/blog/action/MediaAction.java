package net.eleword.blog.action;

import javax.servlet.http.HttpServletRequest;

import net.eleword.blog.entity.Media;
import net.eleword.blog.service.MediaService;
import net.eleword.blog.util.DateUtils;
import net.eleword.blog.util.Pagination;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * TODO 此处填写 class 信息
 * @author krisjin (mailto:krisjin86@163.com)
 * @date  2014-4-24上午9:58:18
 */
@Controller
public class MediaAction {

	@Autowired
	private MediaService mediaService;
	
	
	@RequestMapping(value = "/admin/medias.htm", method = RequestMethod.GET)
	public String list(HttpServletRequest request){
		Pagination<Media> page = new Pagination<Media>();
		String pageCount = request.getParameter("page");

		if (StringUtils.isEmpty(pageCount) || pageCount==null) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(pageCount));
		}
		page.getStartPage();
		page = mediaService.selectMediaWithPage(page,3);

		request.setAttribute("pa", page);
		request.setAttribute("flag", "query");
		return "admin/listMedia.htm";
	}
	
	@RequestMapping(value = "/admin/media/add.htm", method = RequestMethod.GET)
	public String add(){
		
		return "admin/addMedia.htm";
	}
	
	@RequestMapping(value = "/admin/media/save.htm", method = RequestMethod.POST)
	public String save(@RequestParam(value = "url") String url,
					   @RequestParam(value = "name") String name,
					   @RequestParam(value = "status") int status,
					   HttpServletRequest request){
		
		Media media = new Media();
		media.setCreateDate(DateUtils.getCurrentDateTime());
		media.setName(name);
		media.setUrl(url);
		media.setStatus(status);
		mediaService.addMedia(media);
		return "redirect:/admin/medias.htm";
	}
	
	@RequestMapping(value = "/admin/media/{id}.htm",method=RequestMethod.GET)
	public String update(@PathVariable("id") Long id,HttpServletRequest request){
		Pagination<Media> page = new Pagination<Media>();
		String pageCount = request.getParameter("page");

		if (StringUtils.isEmpty(pageCount) || pageCount==null) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(pageCount));
		}
		page.getStartPage();
		page = mediaService.selectMediaWithPage(page,3);
		
		Media media =mediaService.selectMedia(id);
		request.setAttribute("pa", page);
		request.setAttribute("media", media);
		request.setAttribute("flag", "update");
		return "admin/listMedia.htm";
	}
	
	@RequestMapping(value = "/admin/media/updSave.htm",method=RequestMethod.POST)
	public String updateSave(@RequestParam(value = "url") String url,
						     @RequestParam(value = "name") String name,
						     @RequestParam(value = "status") int status,
						     @RequestParam(value = "id") Long id){
		
		Media media = new Media();
		media.setName(name);
		media.setUrl(url);
		media.setStatus(status);
		media.setId(id);
		mediaService.updateMedia(media);
		
		return "redirect:/admin/medias.htm";
	}
	
}

