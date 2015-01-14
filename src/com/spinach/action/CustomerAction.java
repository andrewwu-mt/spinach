package com.spinach.action;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.spinach.bean.MailUtil;
import com.spinach.dao.CustomerDAO;
import com.spinach.dao.KabupatenDAO;
import com.spinach.dbo.Customer;
import com.spinach.dbo.Kabupaten;

public class CustomerAction extends ActionSupport{
	
	private CustomerDAO customerDAO;
	private KabupatenDAO kabupatenDAO;
	
	private String name;
	private String last;
	private String email;
	private String password;
	
	private String address;
	private String address2;
	private String phone;
	private Integer post;
	
	private Integer kabupatenId;
	private Integer customerId;
	
	private String oldPwd;
	private String newPwd;
	
	private String threadHost;
	
	public String updatePwd(){
		Customer cus = customerDAO.findById(customerId);
		if(!oldPwd.equals(cus.getPassword())){
			return "passworderror";
		} else {
			cus.setPassword(newPwd);
			customerDAO.update(cus);
		}
		
		return SUCCESS;
	}
	
	public String getSession(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		if(session.getAttribute("customer") != null){
			Customer customer = (Customer) session.getAttribute("customer");
			request.setAttribute("customer", customer);
		}
		
		return SUCCESS;
	}
	
	public String saveRecord(){
		Customer customer = new Customer();
		customer.setName(name);
		customer.setEmail(email);
		customer.setPassword(password);
		customer.setInsertDate(new Timestamp(System.currentTimeMillis()));
		
		customerDAO.save(customer);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("customer", customer);
		
		return "successsave";
	}
	
	public String updateRecord(){
		Kabupaten kab = kabupatenDAO.findById(kabupatenId);
		Customer cus = customerDAO.findById(customerId);
		cus.setName(name);
		cus.setLast(last);
		cus.setEmail(email);
		cus.setKabupaten(kab);
		cus.setPhone(phone);
		cus.setAddress(address);
		cus.setAddress2(address2);
		cus.setPost(post);
		
		customerDAO.update(cus);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("customer");
		session.setAttribute("customer", cus);
		
		return SUCCESS;
	}
	
	public String login(){
		List<Customer> customerList = customerDAO.findByProperty("email", email);
		if(customerList.size() != 0){
			Customer customer = customerList.get(0);
			if(customer.getPassword().equals(password)){
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				session.setAttribute("customer", customer);
				return "successlogin";
			} else {
				return "error";
			}
		} else {
			return "error";
		}
	}
	
	public String logout(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("customer");
		
		return "successlogout";
	}

	public String forget(){
		HttpServletRequest request = ServletActionContext.getRequest();
		threadHost = request.getScheme() + "://" + request.getHeader("host") + request.getContextPath();
		List<Customer> customerList = customerDAO.findByEmail(email);

		if(customerList.size() != 0){
			oldPwd = customerList.get(0).getPassword();
			
			new Thread(new Runnable(){
				public void run() {
					sendMail(threadHost);
				}
			}).start();
		} else {
			return "error";
		}
		
		return "sent";
	}
	
	public void sendMail(String host){

		String website = "http://spinachstore.com/";
		String link = "<a href="+host+"/index#loginModal>Click to login</a>"; 
		String title = "Retrieve password Spinachstore";
		
		String content = 
				"Your password is <strong>"+oldPwd+"</strong> \n" +
				link+" \n\n" +
				"Terima kasih. \n\n";
		
		MailUtil.sendEmail(email, null, website, title, content, link, null, null);
	}
	
	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public KabupatenDAO getKabupatenDAO() {
		return kabupatenDAO;
	}

	public void setKabupatenDAO(KabupatenDAO kabupatenDAO) {
		this.kabupatenDAO = kabupatenDAO;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getKabupatenId() {
		return kabupatenId;
	}

	public void setKabupatenId(Integer kabupatenId) {
		this.kabupatenId = kabupatenId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public Integer getPost() {
		return post;
	}

	public void setPost(Integer post) {
		this.post = post;
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

}
