package com.spinach.json;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;
import org.json.simple.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.spinach.dao.CustomerDAO;
import com.spinach.dbo.Customer;

public class JsonCustomer extends ActionSupport{
	
	private JSONObject jsonResult;
	
	private CustomerDAO customerDAO;
	
	private String email;
	private Integer customerId;
	
	public String chkEmail(){
		jsonResult = new JSONObject();
		
		if(customerId != null){
			Customer customer = customerDAO.findById(customerId);
			if(!customer.getEmail().equals(email)){
				List<Customer> customerList = customerDAO.findByProperty("email", email);
				jsonResult.put("value", customerList.size());
			} else {
				jsonResult.put("value", 0);
			}
		} else {
			List<Customer> customerList = customerDAO.findByProperty("email", email);
			jsonResult.put("value", customerList.size());
		}
		
		return SUCCESS;
	}

	public JSONObject getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(JSONObject jsonResult) {
		this.jsonResult = jsonResult;
	}

	@JSON(serialize = false)
	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	
	

}
