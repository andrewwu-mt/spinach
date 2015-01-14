package com.spinach.action;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.spinach.bean.AES;
import com.spinach.bean.MailUtil;
import com.spinach.dao.CustomerDAO;
import com.spinach.dao.KabupatenDAO;
import com.spinach.dao.OrderDAO;
import com.spinach.dao.PaymentMethodDAO;
import com.spinach.dao.ProductDAO;
import com.spinach.dao.ShipDAO;
import com.spinach.dao.ShipTypeDAO;
import com.spinach.dao.StockDAO;
import com.spinach.dbo.Customer;
import com.spinach.dbo.Kabupaten;
import com.spinach.dbo.Order;
import com.spinach.dbo.PaymentMethod;
import com.spinach.dbo.Product;
import com.spinach.dbo.Ship;
import com.spinach.dbo.ShipType;
import com.spinach.dbo.Stock;

public class OrderAction extends ActionSupport{
	
	private String name;
	private String last;
	private String email;
	private String address;
	private String address2;
	private String phone;
	private int shipTypeId;
	private int post;
	private int kabupatenId;
	private int provinsiId;
	private String comment;
	private Integer customerId;
	private Integer paymentMethodId;
	private Integer amount;
	
	private Ship threadShip;
	private String threadHost;
	
	private String shipName;
	private String shipLast;
	private String shipAddr;
	private String shipAddr2;
	private Integer shipPost;
	private Integer shipKabupatenId;
	private String shipPhone;
	
	private Integer subtotal;
	private Integer shippingFee;
	private Integer total;
	
	private CustomerDAO customerDAO;
	private ProductDAO productDAO;
	private OrderDAO orderDAO;
	private ShipDAO shipDAO;
	private PaymentMethodDAO paymentMethodDAO;
	private StockDAO stockDAO;
	private KabupatenDAO kabupatenDAO;
	private ShipTypeDAO shipTypeDAO;
	
	private Integer checkbox;
	
	public String add(){
		Map<Integer, List<Object>> cartList = new HashMap<Integer, List<Object>>();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		cartList = (Map<Integer, List<Object>>) session.getAttribute("cartList");
		
		if(cartList != null && cartList.size() != 0){
			//Update customer detail
			Customer customer = customerDAO.findById(customerId);
			Kabupaten kab = kabupatenDAO.findById(kabupatenId);
			customer.setName(name);
			customer.setLast(last);
			customer.setEmail(email);
			customer.setKabupaten(kab);
			customer.setPhone(phone);
			customer.setAddress(address);
			customer.setAddress2(address2);
			customer.setPost(post);
			customerDAO.update(customer);
			
			session.setAttribute("customer", customer);
			
			PaymentMethod pm = paymentMethodDAO.findById(paymentMethodId);
			
			//Create Ship
			Ship ship = new Ship();
			Long shipId = System.currentTimeMillis();
			ship.setShipId(shipId);
			ship.setCustomer(customer);
			ship.setInsertDate(new Timestamp(System.currentTimeMillis()));
			ship.setStatus((short) 0);
			ShipType shipType = shipTypeDAO.findById(shipTypeId);
			ship.setShipType(shipType);
			ship.setSubtotal(subtotal);
			ship.setTotal(total);
			ship.setFee(shippingFee);
			
			if(checkbox != null){
				ship.setShipName(name);
				ship.setShipLast(last);
				ship.setShipAddress(address);
				ship.setShipAddress2(address2);
				ship.setShipPost(post);
				ship.setShipKabupaten(kab);
				ship.setShipPhone(phone);
			} else {
				ship.setShipName(shipName);
				ship.setShipLast(shipLast);
				ship.setShipAddress(shipAddr);
				ship.setShipAddress2(shipAddr2);
				ship.setShipPost(shipPost);
				Kabupaten shipKabupaten = kabupatenDAO.findById(shipKabupatenId);
				ship.setShipKabupaten(shipKabupaten);
				ship.setShipPhone(shipPhone);
			}
			
			
			
			ship.setPaymentMethod(pm);
			shipDAO.save(ship);
			
			for(int key : cartList.keySet()){
				Product product = productDAO.findById(key);
				
				int amount = (Integer) cartList.get(key).get(1);
				int type = (Integer) cartList.get(key).get(2);
				
				if(type == 2){
					String m = product.getDescription().split("x")[0];
					int mult = Integer.valueOf(m);
					amount = amount*mult;
				}
				
				int price = (Integer) cartList.get(key).get(3);
				
				Order order = new Order();
				order.setCustomer(customer);
				order.setProduct(product);
				order.setAmount(amount);
				order.setType(type);
				order.setPrice(price);
				order.setShip(ship);
				
				orderDAO.save(order);
				
				Stock stock = (Stock) stockDAO.findByProperty("product", product).get(0);
				int total = stock.getNumber();
				String desc = product.getDescription();
				String multiplier = desc.split("x")[0];
				if(type == 2){
					amount = (amount * Integer.valueOf(multiplier));
				}
				
				int remainder = total - amount;
				stock.setNumber(remainder);
				stockDAO.update(stock);
			}

			String host = request.getScheme() + "://" + request.getHeader("host") + request.getContextPath();
			Ship shipResult = shipDAO.findByIdJoin(shipId);
			
			request.setAttribute("host", host);
			request.setAttribute("ship", shipResult);
			request.setAttribute("total", total);
			request.setAttribute("amount", amount);
			request.setAttribute("shipId", ship.getShipId());

			session.removeAttribute("cartList");
			
			if(paymentMethodId == 2){
				AES aes = new AES();
				String cert = aes.encrypt(ship.getShipId().toString());
				request.setAttribute("cert", cert);
				return "paypal";
			} else {
				threadShip = ship;
				threadHost = host;
				
				Thread t = new Thread(new Runnable(){
					@Override
					public void run() {
						// TODO Auto-generated method stub
						sendMail(threadShip, threadHost);
					}
				});
				t.start();
				
				return SUCCESS;
			}
		} else {
			return "cartempty";
		}
		
	}
	
	public String paypal(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("amount", amount);
		
		return SUCCESS;
	}
	
	public void sendMail(Ship ship, String host){
		DecimalFormat df = new DecimalFormat("#,###");
		
		String totalPrice = df.format(ship.getSubtotal());
		String totalFee = df.format(ship.getFee());
		String totalAll = df.format(ship.getTotal());
		
		String website = "http://spinachstore.com/";
		String link = "<a href="+host+"/order-received?id="+ship.getShipId()+">Lihat detail pemesanan anda</a>"; 

		String title = "Konfirmasi pemesanan spinach";
		String adminFee = "";
		if(ship.getPaymentMethod().getPaymentMethodId() == 3){
			adminFee = "IDR 10,000 (Admin Fee) \n";
		}
		
		String content = ship.getCustomer().getName() + ", terima kasih untuk pemesanannya. \n" +
				"ID pemesanan anda adalah "+ship.getShipId()+" dengan total harga :\n\n" +
				"IDR "+totalPrice+" \n" +
				"IDR "+totalFee+" (Shipping) \n" +
				adminFee +
				"--------------------------------- + \n" +
				"IDR "+totalAll+ "\n\n"+
				"Pembayaran di transfer ke rekening berikut ini : \n\n" +
				"Rek. BCA : 8710085669 \n" +
				"a/n : ANDREW GOTAMA \n\n" +
				"Pengiriman mulai dilakukan setelah pembayaran. \n" +
				"Mohon segera dilunaskan sesuai nominal yang terterai dan segera konfirmasi ke email spinachstore@gmail.com. \n" +
				"Data yang harus dilampirkan adalah nomor rekening pembayar dan nominalnya. \n\n" +
				"Klik link berikut ini untuk melihat detail pemesanan anda : \n" +
				link+" \n\n" +
				"Terima kasih. \n\n" +
				"*NB. Untuk pertanyaan mengenai Cash on Delivery, silahkan hubungi kami melalui nomor HP. 081216438899 atau email spinachstore@gmail.com.";
		
		MailUtil.sendEmail(ship.getCustomer().getEmail(), ship.getCustomer().getName(), website, title, content, link, ship.getShipId(), totalPrice);
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

	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public ShipDAO getShipDAO() {
		return shipDAO;
	}

	public void setShipDAO(ShipDAO shipDAO) {
		this.shipDAO = shipDAO;
	}

	public StockDAO getStockDAO() {
		return stockDAO;
	}

	public void setStockDAO(StockDAO stockDAO) {
		this.stockDAO = stockDAO;
	}

	public ShipTypeDAO getShipTypeDAO() {
		return shipTypeDAO;
	}

	public void setShipTypeDAO(ShipTypeDAO shipTypeDAO) {
		this.shipTypeDAO = shipTypeDAO;
	}

	public int getShipTypeId() {
		return shipTypeId;
	}

	public void setShipTypeId(int shipTypeId) {
		this.shipTypeId = shipTypeId;
	}

	public int getPost() {
		return post;
	}

	public void setPost(int post) {
		this.post = post;
	}

	public int getKabupatenId() {
		return kabupatenId;
	}

	public void setKabupatenId(int kabupatenId) {
		this.kabupatenId = kabupatenId;
	}

	public KabupatenDAO getKabupatenDAO() {
		return kabupatenDAO;
	}

	public void setKabupatenDAO(KabupatenDAO kabupatenDAO) {
		this.kabupatenDAO = kabupatenDAO;
	}

	public int getProvinsiId() {
		return provinsiId;
	}

	public void setProvinsiId(int provinsiId) {
		this.provinsiId = provinsiId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(Integer paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getShipLast() {
		return shipLast;
	}

	public void setShipLast(String shipLast) {
		this.shipLast = shipLast;
	}

	public String getShipAddr() {
		return shipAddr;
	}

	public void setShipAddr(String shipAddr) {
		this.shipAddr = shipAddr;
	}

	public String getShipAddr2() {
		return shipAddr2;
	}

	public void setShipAddr2(String shipAddr2) {
		this.shipAddr2 = shipAddr2;
	}

	public Integer getShipPost() {
		return shipPost;
	}

	public void setShipPost(Integer shipPost) {
		this.shipPost = shipPost;
	}

	public Integer getShipKabupatenId() {
		return shipKabupatenId;
	}

	public void setShipKabupatenId(Integer shipKabupatenId) {
		this.shipKabupatenId = shipKabupatenId;
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

	public Integer getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(Integer shippingFee) {
		this.shippingFee = shippingFee;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public PaymentMethodDAO getPaymentMethodDAO() {
		return paymentMethodDAO;
	}

	public void setPaymentMethodDAO(PaymentMethodDAO paymentMethodDAO) {
		this.paymentMethodDAO = paymentMethodDAO;
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

	public Integer getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(Integer checkbox) {
		this.checkbox = checkbox;
	}

	public Ship getThreadShip() {
		return threadShip;
	}

	public void setThreadShip(Ship threadShip) {
		this.threadShip = threadShip;
	}

	public String getThreadHost() {
		return threadHost;
	}

	public void setThreadHost(String threadHost) {
		this.threadHost = threadHost;
	}

}
