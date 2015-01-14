package com.spinach.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.spinach.dao.ExchangeDAO;
import com.spinach.dao.ProductDAO;
import com.spinach.dao.StockDAO;
import com.spinach.dbo.Exchange;
import com.spinach.dbo.Product;

public class CartAction extends ActionSupport{
	
	private int id;
	private int amount;
	private int type;
	private int productId;
	private ProductDAO productDAO;
	private StockDAO stockDAO;
	private ExchangeDAO exchangeDAO;
	
	private int total;
	private String productName;
	private String name;
	private String address;
	private String phone;
	private String email;
	private int provinsiId;
	private int shipTypeId;
	private String host;
	
	
	public String allRecords(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if(session.getAttribute("cartList") != null){
			Map<Integer, List<Object>> cartList = (Map<Integer, List<Object>>) session.getAttribute("cartList");
			int sum = 0;
			for(int i : cartList.keySet()){
				int value = (Integer) cartList.get(i).get(3);
				sum += value;
			}
			request.setAttribute("cartTotal", sum);			
			request.setAttribute("cartList", cartList);
			request.setAttribute("cartSize", cartList.size());
			Integer totalBottle = calculateTotal(cartList);
			request.setAttribute("totalBottle", totalBottle);
			
			Exchange exchange = exchangeDAO.findById(1);
			request.setAttribute("exchange", exchange);
		} else {
			request.setAttribute("cartSize", 0);
		}
		
		return SUCCESS;
	}

	public String add(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		host = request.getScheme() + "://" + request.getHeader("host") + request.getContextPath();
		Map<Integer, List<Object>> cartList = new HashMap<Integer, List<Object>>();
		Product product = productDAO.findById(productId);
		
		if(product != null){
			List<Object> list = new ArrayList<Object>();
			list.add(product.getShortName().replace("&nbsp;", " "));
			list.add(amount);
			list.add(type);
			list.add(total);
			list.add(product.getPriceBottle());
			list.add(product.getSrc());

			if(session.getAttribute("cartList") == null){
				cartList.put(product.getProductId(), list);
				session.setAttribute("cartList", cartList);
			} else {
				cartList = (Map<Integer, List<Object>>) session.getAttribute("cartList");
				
				cartList.put(product.getProductId(), list);
				session.setAttribute("cartList", cartList);
			}
		}
		return SUCCESS;
		
	}
	
	public Integer calculateTotal(Map<Integer, List<Object>> cartList){
		int totalBottle = 0;
		
		for(int key : cartList.keySet()){
			Product product = productDAO.findById(key);
			
			int amount = (Integer) cartList.get(key).get(1);
			int type = (Integer) cartList.get(key).get(2);
			
			if(type == 2){
				String m = product.getDescription().split("x")[0];
				int mult = Integer.valueOf(m);
				amount = amount*mult;
			}
			
			totalBottle += amount;
			String desc = product.getDescription();
			String multiplier = desc.split("x")[0];
			if(type == 2){
				amount = (amount * Integer.valueOf(multiplier));
			}
			
		}
		
		return totalBottle;
	}
	
	public String delete(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Map<Integer, List<Object>> cartList = (Map<Integer, List<Object>>) session.getAttribute("cartList");
		cartList.remove(productId);
		if(cartList != null && cartList.size() != 0){
			return SUCCESS;
		} else {
			return "cartempty";
		}
	}
	
	public String list(){
		HttpServletRequest request = ServletActionContext.getRequest();
		host = request.getScheme() + "://" + request.getHeader("host") + request.getContextPath();
		HttpSession session = request.getSession();
		Map<Integer, List<Object>> cartList = (Map<Integer, List<Object>>) session.getAttribute("cartList");
		if(cartList != null && cartList.size() != 0){
			return SUCCESS;
		} else {
			return "cartempty";
		}
	}
	
	public String checkout(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Map<Integer, List<Object>> cartList = (Map<Integer, List<Object>>) session.getAttribute("cartList");
		if(cartList != null && cartList.size() != 0){
			return SUCCESS;
		} else {
			return "cartempty";
		}
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getShipTypeId() {
		return shipTypeId;
	}

	public void setShipTypeId(int shipTypeId) {
		this.shipTypeId = shipTypeId;
	}

	public int getProvinsiId() {
		return provinsiId;
	}

	public void setProvinsiId(int provinsiId) {
		this.provinsiId = provinsiId;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public StockDAO getStockDAO() {
		return stockDAO;
	}

	public void setStockDAO(StockDAO stockDAO) {
		this.stockDAO = stockDAO;
	}

	public ExchangeDAO getExchangeDAO() {
		return exchangeDAO;
	}

	public void setExchangeDAO(ExchangeDAO exchangeDAO) {
		this.exchangeDAO = exchangeDAO;
	}
	
}
