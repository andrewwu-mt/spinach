package com.spinach.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.spinach.dao.TypeDAO;

public class TypeAction extends ActionSupport{
	
	private TypeDAO typeDAO;
	
	public String allRecords(){
		List typeList = typeDAO.findAll();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("typeList", typeList);
		
		return SUCCESS;
	}

	public TypeDAO getTypeDAO() {
		return typeDAO;
	}

	public void setTypeDAO(TypeDAO typeDAO) {
		this.typeDAO = typeDAO;
	}
	
	

}
