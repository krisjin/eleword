package net.eleword.blog.action;

import net.eleword.blog.entity.Blog;
import net.eleword.blog.entity.Color;
import net.eleword.blog.service.BlogService;
import net.eleword.blog.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 博客配置维护
 *
 * @author krisjin (mailto:krisjin86@163.com)
 */
@Controller
public class BlogConfigAction {

	@Autowired
	private ColorService colorService;

	@Autowired
	private BlogService blogService;

	@RequestMapping(value = "/admin/blog/config", method = RequestMethod.GET)
	public String config(HttpServletRequest request) {
		List<Color> colors = colorService.queryAllColors();
		List<Blog> blogConfig = blogService.queryAllBlogConfig();
		Blog blog = new Blog();
		if (blogConfig.size() > 0) {
			blog = blogConfig.get(0);
		}
		request.setAttribute("blog", blog);
		request.setAttribute("colors", colors);
		return "admin/blogConfig.htm";
	}

	@RequestMapping(value = "/admin/blog/config/save", method = RequestMethod.POST)
	public String updateConfig(
			@RequestParam(value = "code") String code,
			@RequestParam(value = "title") String title,
			@RequestParam(value = "description") String description,
			@RequestParam(value = "id") Long id,
			@RequestParam(value = "banner_color") String banner_color
	) {
		Blog blog = new Blog();
		if (!(id == null)) {
			blog.setId(id);
		}
		blog.setBackground(code);
		blog.setTitle(title);
		blog.setDescription(description);
		blog.setBanner_color(banner_color);
		blogService.saveOrUpdate(blog);

		return "redirect:/admin/blog/config";
	}

}
