package com.spinach.action;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.spinach.dao.AdminDAO;
import com.spinach.dao.CustomerDAO;
import com.spinach.dao.KabupatenDAO;
import com.spinach.dao.OrderDAO;
import com.spinach.dao.PaymentMethodDAO;
import com.spinach.dao.ProductDAO;
import com.spinach.dao.ShipDAO;
import com.spinach.dao.StockDAO;
import com.spinach.dbo.Admin;
import com.spinach.dbo.Customer;
import com.spinach.dbo.Kabupaten;
import com.spinach.dbo.Order;
import com.spinach.dbo.PaymentMethod;
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
	private CustomerDAO customerDAO;
	private String path;
	
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
	

	private KabupatenDAO kabupatenDAO;
	private PaymentMethodDAO paymentMethodDAO;
	
	private String last;
	private String email;
	
	private String address;
	private String address2;
	private String phone;
	private Integer post;
	
	private Integer kabupatenId;
	private Integer customerId;
	
	private String oldPwd;
	private String newPwd;
	
	private Integer paymentMethodId;
	private String shipAddress;
	private String shipAddress2;
	private String shipPhone;
	private Integer subtotal;
	private Integer fee;
	private Integer total;
	
	public String execute(){
		return SUCCESS;
	}

	//========================================================================
	
	//User Record
	public String allUserRecords(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List customerList = customerDAO.findAll();
		request.setAttribute("customerList", customerList);
		
		return SUCCESS;
	}
	
	public String getUserRecord(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Customer customer = customerDAO.findById(customerId);
		request.setAttribute("customer", customer);
		
		return SUCCESS;
	}
	
	public String saveUserRecord(){
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

	public String updateUserRecord(){
		Kabupaten kab = kabupatenDAO.findById(kabupatenId);
		Customer cus = customerDAO.findById(customerId);
		cus.setName(name);
		cus.setLast(last);
		cus.setEmail(email);
		cus.setKabupaten(kab);
		cus.setPhone(phone);
		cus.setPassword(password);
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

	public String deleteUserRecord(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("path", path);
		try{
			Customer cus = customerDAO.findById(customerId);
			customerDAO.delete(cus);
			
			return "successdelete";
		} catch (Exception e){
			return "deleteusererror";
		}
	}
	
	
	//========================================================================
	
	
	//login
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

	//========================================================================
	
	
	//Stock Records
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
	

	//========================================================================
	

	//Order Records
	public String getShipDetailRecord(){
		orderList = orderDAO.findByProperty("ship.shipId", shipId);
		return SUCCESS;
	}
	
	
	//========================================================================
	
	
	//Ship Records
	public String getShipRecord(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Ship ship = shipDAO.findById(shipId);
		request.setAttribute("ship", ship);
		
		return SUCCESS;
	}
	
	public String updateShipRecord(){
		Ship ship = shipDAO.findById(shipId);
		Kabupaten shipKabupaten = kabupatenDAO.findById(kabupatenId);
		PaymentMethod paymentMethod = paymentMethodDAO.findById(paymentMethodId);
		
		ship.setShipAddress(shipAddress);
		ship.setShipAddress2(shipAddress2);
		ship.setShipKabupaten(shipKabupaten);
		ship.setShipPhone(shipPhone);
		ship.setSubtotal(subtotal);
		ship.setFee(fee);
		ship.setTotal(total);
		ship.setStatus(status);
		ship.setPaymentMethod(paymentMethod);
		shipDAO.update(ship);
		
		return SUCCESS;
	}
	
	public String getShipListRecord(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Ship> shipList = shipDAO.findByMonth(month, year);
		Long subtotal = shipDAO.findPrice(month, year, "subtotal");
		Long fee = shipDAO.findPrice(month, year, "fee");
		Long adminFee = shipDAO.findAdminFee(month, year);
		Long total = shipDAO.findPrice(month, year, "total");
		
		if(subtotal == null) subtotal = (long) 0;
		if(fee == null) fee = (long) 0;
		if(adminFee == null) adminFee = (long) 0;
		if(total == null) total = (long) 0;
		
		request.setAttribute("shipList", shipList);
		request.setAttribute("subtotal", subtotal);
		request.setAttribute("fee", fee+adminFee);
		request.setAttribute("total", total);
		request.setAttribute("month", month);
		request.setAttribute("year", year);
		
		return SUCCESS;
	}
	

	public String deleteShipRecord(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("path", path);
		
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
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("path", path);
		
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

	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public KabupatenDAO getKabupatenDAO() {
		return kabupatenDAO;
	}

	public void setKabupatenDAO(KabupatenDAO kabupatenDAO) {
		this.kabupatenDAO = kabupatenDAO;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getPost() {
		return post;
	}

	public void setPost(Integer post) {
		this.post = post;
	}

	public Integer getKabupatenId() {
		return kabupatenId;
	}

	public void setKabupatenId(Integer kabupatenId) {
		this.kabupatenId = kabupatenId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public PaymentMethodDAO getPaymentMethodDAO() {
		return paymentMethodDAO;
	}

	public void setPaymentMethodDAO(PaymentMethodDAO paymentMethodDAO) {
		this.paymentMethodDAO = paymentMethodDAO;
	}

	public Integer getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(Integer paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public String getShipAddress2() {
		return shipAddress2;
	}

	public void setShipAddress2(String shipAddress2) {
		this.shipAddress2 = shipAddress2;
	}

	public String getShipPhone() {
		return shipPhone;
	}

	public void setShipPhone(String shipPhone) {
		this.shipPhone = shipPhone;
	}

	public Integer getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}

	public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}
