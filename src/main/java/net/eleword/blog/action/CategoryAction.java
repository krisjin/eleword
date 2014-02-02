package net.eleword.blog.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.eleword.blog.entity.Category;
import net.eleword.blog.service.CategoryService;
import net.eleword.blog.util.ConstantEnum;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-1-27上午11:14:00
 */
@Controller("categoryAction")
@Scope("prototype")
public class CategoryAction extends ActionSupport {

	private String categoryName;
	private String priority;
	private String id;

	@Autowired
	private CategoryService categoryService;

	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute(ConstantEnum.pageTitle.toString(), "分类管理");
		return "list";
	}

	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute(ConstantEnum.pageTitle.toString(), "新增分类");
		return "add";
	}

	public String save() {
		
		Category category = new Category();
		category.setName(categoryName);
		category.setPriority(Integer.valueOf(priority));
		categoryService.add(category);
		return "queryRedirect";

	}

	public String update(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String categoryId=request.getParameter("categoryId");
		Category category=categoryService.selectCategoryById(Long.valueOf(categoryId));
		List<Category> categories = categoryService.selectAll();
		request.setAttribute("categories", categories);
		request.setAttribute("updCategory", category);
		request.setAttribute("flag", "update");
		return "list";
	}
	
	public String updateSave(){
		
		Category category =new Category();
		category.setName(categoryName);
		category.setPriority(Integer.valueOf(priority));
		category.setId(Long.valueOf(id));
		categoryService.update(category);
		return "queryRedirect";
	}
	
	public String list() {

		List<Category> categories = categoryService.selectAll();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("flag", "query");
		request.setAttribute("categories", categories);
		return "list";

	}

	public String delete() {

		HttpServletRequest request = ServletActionContext.getRequest();
		String categoryId = request.getParameter("categoryId");

		categoryService.deleteByCategoryId(Long.valueOf(categoryId));
		return "queryRedirect";
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
