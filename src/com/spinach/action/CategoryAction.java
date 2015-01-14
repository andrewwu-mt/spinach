package com.spinach.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.spinach.dao.CategoryDAO;
import com.spinach.dbo.Category;

public class CategoryAction extends ActionSupport{
	
	private CategoryDAO categoryDAO;
	
	public String allRecords(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Category> categoryList = categoryDAO.findAll();
		
		request.setAttribute("categoryList", categoryList);
		
		return SUCCESS;
	}

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	
}
