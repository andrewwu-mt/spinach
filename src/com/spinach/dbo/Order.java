package com.spinach.dbo;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Product product;
	private Customer customer;
	private Ship ship;
	private Integer amount;
	private Integer type;
	private Integer price;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(Product product, Customer customer, Ship ship, Integer amount,
			Integer type, Integer price) {
		this.product = product;
		this.customer = customer;
		this.ship = ship;
		this.amount = amount;
		this.type = type;
		this.price = price;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Ship getShip() {
		return this.ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}