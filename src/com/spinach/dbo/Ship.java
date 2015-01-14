package com.spinach.dbo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Ship entity. @author MyEclipse Persistence Tools
 */

public class Ship implements java.io.Serializable {

	// Fields

	private Long shipId;
	private ShipType shipType;
	private Customer customer;
	private Timestamp insertDate;
	private Short status;
	private Integer total;
	private Integer subtotal;
	private Integer fee;
	private Set orders = new HashSet(0);
	private String comment;
	private PaymentMethod paymentMethod;
	private String paymentStatus;
	private String txnId;
	
	private String shipName;
	private String shipLast;
	private String shipAddress;
	private String shipAddress2;
	private Integer shipPost;
	private Kabupaten shipKabupaten;
	private String shipPhone;

	// Constructors

	/** default constructor */
	public Ship() {
	}

	/** full constructor */
	public Ship(String txnId, String paymentStatus, Long shipId, Integer subtotal, ShipType shipType, Customer customer,
			Timestamp insertDate, Short status, Integer total, Integer fee,
			Set orders, String comment, PaymentMethod paymentMethod,
			String shipName,
			String shipLast,
			String shipAddress,
			String shipAddress2,
			Integer shipPost,
			Kabupaten shipKabupaten,
			String shipPhone
			) {
		this.shipId = shipId;
		this.shipType = shipType;
		this.customer = customer;
		this.insertDate = insertDate;
		this.status = status;
		this.total = total;
		this.fee = fee;
		this.orders = orders;
		this.comment = comment;
		this.subtotal = subtotal;
		this.paymentMethod = paymentMethod;
		this.txnId = txnId;
		this.paymentStatus = paymentStatus;
		this.shipName = shipName;
		this.shipLast = shipLast;
		this.shipAddress = shipAddress;
		this.shipAddress2 = shipAddress2;
		this.shipPost = shipPost;
		this.shipKabupaten = shipKabupaten;
		this.shipPhone = shipPhone;
		
		
	}

	// Property accessors

	public Long getShipId() {
		return this.shipId;
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

	public Integer getShipPost() {
		return shipPost;
	}

	public void setShipPost(Integer shipPost) {
		this.shipPost = shipPost;
	}

	public Kabupaten getShipKabupaten() {
		return shipKabupaten;
	}

	public void setShipKabupaten(Kabupaten shipKabupaten) {
		this.shipKabupaten = shipKabupaten;
	}

	public String getShipPhone() {
		return shipPhone;
	}

	public void setShipPhone(String shipPhone) {
		this.shipPhone = shipPhone;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public void setShipId(Long shipId) {
		this.shipId = shipId;
	}

	public Integer getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public ShipType getShipType() {
		return this.shipType;
	}

	public void setShipType(ShipType shipType) {
		this.shipType = shipType;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Timestamp getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Timestamp insertDate) {
		this.insertDate = insertDate;
	}

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Integer getTotal() {
		return this.total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getFee() {
		return this.fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

}