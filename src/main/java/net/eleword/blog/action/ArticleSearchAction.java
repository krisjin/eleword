package net.eleword.blog.action;

import net.eleword.blog.entity.Blog;
import net.eleword.blog.entity.Folder;
import net.eleword.blog.entity.User;
import net.eleword.blog.search.SearchHelper;
import net.eleword.blog.search.entity.Articles;
import net.eleword.blog.service.ArticleSearchService;
import net.eleword.blog.util.ConstantEnum;
import net.eleword.blog.util.HtmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author krisjin
 * @date 2014-4-30下午3:21:26
 */

@Controller
public class ArticleSearchAction extends BaseAction {

    @Autowired
    private ArticleSearchService aritcleSearchService;

    @RequestMapping(value = "/search.htm", method = RequestMethod.GET)
    public String search(HttpServletRequest request, @RequestParam(value = "q") String q, @RequestParam(value = "page", defaultValue = "1") int page) {
        int totalPages = 0;
        List<Articles> articles = null;
        List result = new ArrayList();
        if (!q.equals("") || q != null) {
            try {
                articles = aritcleSearchService.search(q, 20, page, result);
                if (articles != null && articles.size() > 0) {
                    for (Articles art : articles) {
                        String content = HtmlUtil.subStrByte(HtmlUtil.filterHtml(art.getContent()), 240);
                        art.setContent(SearchHelper.highlight(content, q));
                        art.setTitle(SearchHelper.highlight(art.getTitle(), q));
                    }
                    int totalCount = (Integer) result.get(0);
                    totalPages = (int) (Math.ceil((double) totalCount / (double) 20));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<Blog> blog = blogService.queryAllBlogConfig();
        User user = userService.selectUserByName(ConstantEnum.admin.toString());
        List<Folder> folderList = folderService.selectAllFolder(1);

        if (blog.size() > 0) {
            request.setAttribute("blog", blog.get(0));
        }
        if (user != null)
            request.setAttribute("user", user);

        if (result.size() > 0) {
            request.setAttribute("result", result.get(0));
        }
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("page", page);
        request.setAttribute("q", q);
        request.setAttribute("folderList", folderList);
        request.setAttribute(ConstantEnum.pageTitle.toString(), "Eleword全文搜索");
        request.setAttribute("articles", articles);
        return "search.htm";

    }
}
