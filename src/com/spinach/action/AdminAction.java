package com.spinach.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.spinach.dao.AdminDAO;
import com.spinach.dao.OrderDAO;
import com.spinach.dao.ProductDAO;
import com.spinach.dao.ShipDAO;
import com.spinach.dao.StockDAO;
import com.spinach.dbo.Admin;
import com.spinach.dbo.Order;
import com.spinach.dbo.Product;
import com.spinach.dbo.Ship;
import com.spinach.dbo.Stock;

public class AdminAction extends ActionSupport {
	
	private String username;
	private String password;
	private AdminDAO adminDAO;
	private StockDAO stockDAO;
	private ShipDAO shipDAO;
	private OrderDAO orderDAO;
	private ProductDAO productDAO;
	private int id;
	private int productId;
	private Long shipId;
	
	private String name;
	private String description;
	private int priceBottle;
	private int priceBox;
	private int number;
	private short status;
	private Integer month;
	private Integer year;
	
	private List<Integer> productIds;
	private List<Integer> numbers;
	
	private List<Stock> stockList;
	private List<Order> orderList;
	
	public String login(){
		List<Admin> admin = adminDAO.findByUsername(username);
		if(admin.size() != 0){
			String pwd = admin.get(0).getPassword();
			if(password.equals(pwd)){
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				session.setAttribute("admin", admin);				
				return "successlogin";
			} else {
				return "error";
			}
		} else {
			return "error";
		}
	}
	
	public String getRecord(){
		stockList = stockDAO.findAll();
		return SUCCESS;
	}
	
	public String update(){
		try{
			List<Stock> list = stockDAO.findAll();
			for(int i=0 ; i<list.size() ; i++){
				if(numbers.get(i) != null){
					Stock stock = list.get(i);
					stock.setNumber(numbers.get(i));
					stockDAO.update(stock);
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String getShipListRecord(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Ship> shipList = shipDAO.findByMonth(month, year);
		Long subtotal = shipDAO.findPrice(month, year, "subtotal");
		Long fee = shipDAO.findPrice(month, year, "fee");
		Long adminFee = shipDAO.findAdminFee(month, year);
		Long total = shipDAO.findPrice(month, year, "total");
		
		request.setAttribute("shipList", shipList);
		request.setAttribute("subtotal", subtotal);
		request.setAttribute("fee", fee+adminFee);
		request.setAttribute("total", total);
		request.setAttribute("month", month);
		request.setAttribute("year", year);
		
		return SUCCESS;
	}
	
	public String getShipDetailRecord(){
		orderList = orderDAO.findByProperty("ship.shipId", shipId);
		return SUCCESS;
	}

	public String deleteShipRecord(){
		Ship ship = shipDAO.findById(shipId);
		List<Order> orderList = orderDAO.findByProperty("ship", ship);
		for(int i=0 ; i<orderList.size() ; i++){
			Order order = orderList.get(i);
			Product product = order.getProduct();
			String mult = product.getDescription().split("x")[0];
			int restock = 0;
			if(order.getType() == 1){
				restock = order.getAmount();
			} else {
				restock = order.getAmount() * Integer.valueOf(mult);
			}
			Stock stock = (Stock) stockDAO.findByProperty("product", product).get(0);
			stock.setNumber(stock.getNumber() + restock);
			stockDAO.update(stock);
			orderDAO.delete(order);
		}
		
		shipDAO.delete(ship);
		
		return "successdelete";
	}
	
	public String updateStatus(){
		Ship ship = shipDAO.findByIdJoin(shipId);
		if(status == 0){
			ship.setStatus((short) 1);
		} else {
			ship.setStatus((short) 0);
		}
		
		shipDAO.update(ship);
		
		return SUCCESS;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	public StockDAO getStockDAO() {
		return stockDAO;
	}

	public void setStockDAO(StockDAO stockDAO) {
		this.stockDAO = stockDAO;
	}

	public List<Stock> getStockList() {
		return stockList;
	}

	public void setStockList(List<Stock> stockList) {
		this.stockList = stockList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public ShipDAO getShipDAO() {
		return shipDAO;
	}

	public void setShipDAO(ShipDAO shipDAO) {
		this.shipDAO = shipDAO;
	}

	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public Long getShipId() {
		return shipId;
	}

	public void setShipId(Long shipId) {
		this.shipId = shipId;
	}

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPriceBottle() {
		return priceBottle;
	}

	public void setPriceBottle(int priceBottle) {
		this.priceBottle = priceBottle;
	}

	public int getPriceBox() {
		return priceBox;
	}

	public void setPriceBox(int priceBox) {
		this.priceBox = priceBox;
	}

	public List<Integer> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Integer> productIds) {
		this.productIds = productIds;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

}
