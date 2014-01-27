package net.eleword.blog.action;

import net.eleword.blog.entity.Category;
import net.eleword.blog.service.CategoryService;

import org.apache.commons.lang3.StringUtils;
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

	private String name;
	private String priority;
	private String parentId;

	@Autowired
	private CategoryService categoryService;

	public String execute() {
		return "";
	}

	public String add() {
		return "add";
	}

	public String save() {

		Category category = new Category();
		category.setName(name);
		category.setPriority(Integer.valueOf(priority));
	
		if(StringUtils.isNotBlank(parentId)&& StringUtils.isNotEmpty(parentId)){
			category.setParentId(Long.valueOf(parentId));
		}
		categoryService.add(category);
		return "list";
		
	}

	public String list() {
		
		
		
		return "list";
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

}
