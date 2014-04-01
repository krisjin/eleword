package net.eleword.blog.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.eleword.blog.entity.Category;
import net.eleword.blog.service.CategoryService;
import net.eleword.blog.util.ConstantEnum;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 类别维护
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-1-27上午11:14:00
 */
@Controller
public class CategoryAction{

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/admin/categories/add" ,method=RequestMethod.GET)
	public String add(HttpServletRequest request) {
		request.setAttribute(ConstantEnum.pageTitle.toString(), "新增分类");
		return "add";
	}
	
	@RequestMapping(value="/admin/category/save" ,method=RequestMethod.POST)
	public String save(
			@RequestParam(value="categoryName") String categoryName,
			@RequestParam(value="orderValue") int orderValue
			) {
		Category category = new Category();
		category.setName(categoryName);
		category.setOrderValue(orderValue);
		categoryService.add(category);
		return "redirect:/admin/categories";

	}

	@RequestMapping(value="/admin/category/{categoryId}" ,method=RequestMethod.GET)
	public String update(@PathVariable("categoryId") Long categoryId,HttpServletRequest request){
		Category category=categoryService.selectCategoryById(Long.valueOf(categoryId));
		List<Category> categories = categoryService.selectAll();
		request.setAttribute("categories", categories);
		request.setAttribute("updCategory", category);
		request.setAttribute("flag", "update");
		return "admin/listCategory.htm";
	}
	@RequestMapping(value="/admin/categories/usave" ,method=RequestMethod.POST)
	public String updateSave(
			@RequestParam(value="categoryName") String categoryName,
			@RequestParam(value="orderValue") int orderValue,
			@RequestParam(value="categoryId") Long categoryId
			){
		Category category =new Category();
		category.setName(categoryName);
		category.setOrderValue(orderValue);
		category.setId(Long.valueOf(categoryId));
		categoryService.update(category);
		return "queryRedirect";
	}
	
	@RequestMapping(value="/admin/categories" ,method=RequestMethod.GET)
	public String listCategory(HttpServletRequest request) {
		request.setAttribute(ConstantEnum.pageTitle.toString(), "分类管理");
		List<Category> categories = categoryService.selectAll();
		request.setAttribute("flag", "query");
		request.setAttribute("categories", categories);
		return "admin/listCategory.htm";

	}
	
	@RequestMapping(value="/admin/category/delete/{categoryId}" ,method=RequestMethod.POST)
	public String delete(@PathVariable("categoryId") Long categoryId) {
		categoryService.deleteByCategoryId(Long.valueOf(categoryId));
		return "redirect:/admin/categories";
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}


	
}
