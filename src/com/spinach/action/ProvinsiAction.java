package com.spinach.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.spinach.dao.ProvinsiDAO;
import com.spinach.dbo.Provinsi;

public class ProvinsiAction extends ActionSupport{

	private ProvinsiDAO provinsiDAO;
	
	public String allRecords(){
		List<Provinsi> provinsiList = provinsiDAO.findAll();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("provinsiList", provinsiList );
		
		return SUCCESS;
		
	}

	public ProvinsiDAO getProvinsiDAO() {
		return provinsiDAO;
	}

	public void setProvinsiDAO(ProvinsiDAO provinsiDAO) {
		this.provinsiDAO = provinsiDAO;
	}
	
}
