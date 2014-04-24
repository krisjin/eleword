package net.eleword.blog.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.eleword.blog.entity.Media;
import net.eleword.blog.entity.News;
import net.eleword.blog.service.MediaService;
import net.eleword.blog.service.NewsService;
import net.eleword.blog.util.DateUtils;
import net.eleword.blog.util.Pagination;
import net.eleword.blog.util.ThumbnailsUtils;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 */
@Controller
public class NewsAction {
	
	@Autowired
	private NewsService newsService;
	@Autowired
	private MediaService mediaService;

	@RequestMapping(value = "/admin/news.htm", method = RequestMethod.GET)
	public String list(HttpServletRequest request) {
		Pagination<News> page = new Pagination<News>();
		String pageCount = request.getParameter("page");

		if (StringUtils.isEmpty(pageCount) || pageCount == null) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(pageCount));
		}
		page.getStartPage();
		page = newsService.selectNewsWithPage(page);

		request.setAttribute("pa", page);
		request.setAttribute("flag", "query");
		return "admin/listNews.htm";
	}

	@RequestMapping(value = "/admin/news/add.htm", method = RequestMethod.GET)
	public String add(HttpServletRequest request) {
		List<Media> medias = mediaService.getAllMedia();

		request.setAttribute("medias", medias);
		request.setAttribute("flag", "query");
		return "admin/addNews.htm";
	}
	@RequestMapping(value = "/admin/news/saves.htm", method = RequestMethod.POST)
	public String save(@RequestParam(value = "title") String title,
					   @RequestParam(value = "media") String media,
					   @RequestParam(value = "url") String url,
					   @RequestParam(value = "content") String content,
					   @RequestParam(value = "status") int status,
					   @RequestParam(value = "thumbnails") CommonsMultipartFile thumbnails,
					   HttpServletRequest request) {
		
		News news =new News();
		news.setContent(content);
		news.setTitle(title);
		news.setMedia(media);
		news.setMediaUrl(url);
		news.setStatus(status);
		news.setPostDate(DateUtils.getCurrentDateTime());
		news.setUser("admin");
		news.setThumbnailsUrl(getFilePath(thumbnails.getOriginalFilename()));
		
		
		try {
			ThumbnailsUtils.generateThumbnails(thumbnails.getInputStream(), getOutputFile(thumbnails, request), 220, 150);
		} catch (IOException e) {
			e.printStackTrace();
		}
		newsService.saveNews(news);
		return "redirect:/admin/news.htm";
	}
	
	
	@RequestMapping(value = "/admin/news/{id}.htm", method = RequestMethod.GET)
	public String update(@PathVariable("id") Long id,HttpServletRequest request){
		
		News news=newsService.getNews(id);
		List<Media> medias = mediaService.getAllMedia();

		request.setAttribute("medias", medias);
		request.setAttribute("flag", "update");
		request.setAttribute("news", news);
		return "admin/addNews.htm";
	}
	
	@RequestMapping(value = "/admin/news/updSave.htm", method = RequestMethod.POST)
	public String updateSave(@RequestParam(value = "title") String title,
					   @RequestParam(value = "media") String media,
					   @RequestParam(value = "url") String url,
					   @RequestParam(value = "content") String content,
					   @RequestParam(value = "status") int status,
					   @RequestParam(value = "thumbnails") CommonsMultipartFile thumbnails,
					   @RequestParam(value = "id") Long id,
					   @RequestParam(value = "thumbnailsUrl") String thumbnailsUrl,
					   HttpServletRequest request) {
		
		News news =new News();
		news.setId(id);
		news.setContent(content);
		news.setTitle(title);
		news.setMedia(media);
		news.setMediaUrl(url);
		news.setStatus(status);
		news.setPostDate(DateUtils.getCurrentDateTime());
		news.setUser("admin");
		
		if(thumbnails.getSize()==0){
			news.setThumbnailsUrl(thumbnailsUrl);
		}else{
			news.setThumbnailsUrl(getFilePath(thumbnails.getOriginalFilename()));
			try {
				ThumbnailsUtils.generateThumbnails(thumbnails.getInputStream(), getOutputFile(thumbnails, request), 220, 150);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	
		newsService.updateNews(news);
		return "redirect:/admin/news.htm";
	}
	
	
	
	
	
	@SuppressWarnings("deprecation")
	private File getOutputFile(CommonsMultipartFile file,HttpServletRequest request){
		
		String path="/news/thumb/";
		String filePath=request.getRealPath("/")+path;
		File f =new File(filePath);
		if(!f.exists()){
			f.mkdirs();
		}
		return new File(f,file.getOriginalFilename());
	}
	
	/**
	 * 扩展用
	 * @param fileName
	 * @return
	 */
	private String getFilePath(String fileName){
		String path="/news/thumb/";
		return path+fileName;
	}

}
