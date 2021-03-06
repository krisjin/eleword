package net.eleword.blog.action;

import net.eleword.blog.entity.Category;
import net.eleword.blog.util.ConstantEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 类别维护
 *
 * @author krisjin
 * @date 2014-1-27上午11:14:00
 */
@Controller
public class CategoryAction extends BaseAction {

    @RequestMapping(value = "/admin/categories/add.htm", method = RequestMethod.GET)
    public String add(HttpServletRequest request) {
        request.setAttribute(ConstantEnum.pageTitle.toString(), "新增分类");
        return "add";
    }

    @RequestMapping(value = "/admin/category/save.htm", method = RequestMethod.POST)
    public String save(@RequestParam(value = "categoryName") String categoryName, @RequestParam(value = "orderValue") int orderValue) {
        Category category = new Category();
        category.setName(categoryName);
        category.setOrderValue(orderValue);
        categoryService.add(category);
        return "redirect:/admin/categories.htm";

    }

    @RequestMapping(value = "/admin/category/{categoryId}.htm", method = RequestMethod.GET)
    public String update(@PathVariable("categoryId") Long categoryId, HttpServletRequest request) {
        Category category = categoryService.selectCategoryById(Long.valueOf(categoryId));
        List<Category> categories = categoryService.selectAll();
        request.setAttribute("categories", categories);
        request.setAttribute("updCategory", category);
        request.setAttribute("flag", "update");
        return "admin/listCategory.htm";
    }

    @RequestMapping(value = "/admin/category/usave.htm", method = RequestMethod.POST)
    public String updateSave(@RequestParam(value = "categoryName") String categoryName, @RequestParam(value = "orderValue") int orderValue,
                             @RequestParam(value = "categoryId") Long categoryId) {
        Category category = new Category();
        category.setName(categoryName);
        category.setOrderValue(orderValue);
        category.setId(Long.valueOf(categoryId));
        categoryService.update(category);
        return "redirect:/admin/categories.htm";
    }

    @RequestMapping(value = "/admin/categories.htm", method = RequestMethod.GET)
    public String listCategory(HttpServletRequest request) {
        request.setAttribute(ConstantEnum.pageTitle.toString(), "分类管理");
        List<Category> categories = categoryService.selectAll();
        request.setAttribute("flag", "query");
        request.setAttribute("categories", categories);
        return "admin/listCategory.htm";

    }

    @RequestMapping(value = "/admin/category/delete/{categoryId}.htm", method = RequestMethod.POST)
    public String delete(@PathVariable("categoryId") Long categoryId) {
        categoryService.deleteByCategoryId(Long.valueOf(categoryId));
        return "redirect:/admin/categories";
    }
}
