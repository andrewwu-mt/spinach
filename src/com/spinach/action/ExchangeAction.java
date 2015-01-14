package com.spinach.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.spinach.dao.ExchangeDAO;
import com.spinach.dbo.Exchange;

public class ExchangeAction extends ActionSupport{
	
	private ExchangeDAO exchangeDAO;
	
	private Integer exchangeId;
	
	public String getRecord(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Exchange exchange = exchangeDAO.findById(exchangeId);
		request.setAttribute("exchange", exchange);
		
		return SUCCESS;
	}

	public ExchangeDAO getExchangeDAO() {
		return exchangeDAO;
	}

	public void setExchangeDAO(ExchangeDAO exchangeDAO) {
		this.exchangeDAO = exchangeDAO;
	}

	public Integer getExchangeId() {
		return exchangeId;
	}

	public void setExchangeId(Integer exchangeId) {
		this.exchangeId = exchangeId;
	}
	
	
	
}
