package com.spinach.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.spinach.dao.BestSellerDAO;
import com.spinach.dbo.BestSeller;

public class BestSellerAction extends ActionSupport{
	
	private BestSellerDAO bestSellerDAO;
	
	public String allRecords(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<BestSeller> bestSellerList = bestSellerDAO.findAll();
		request.setAttribute("bestSellerList", bestSellerList);
		
		return SUCCESS;
	}

	public BestSellerDAO getBestSellerDAO() {
		return bestSellerDAO;
	}

	public void setBestSellerDAO(BestSellerDAO bestSellerDAO) {
		this.bestSellerDAO = bestSellerDAO;
	}
	
}
