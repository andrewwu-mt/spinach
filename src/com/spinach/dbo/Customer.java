package com.spinach.dbo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */

public class Customer implements java.io.Serializable {

	// Fields

	private Integer customerId;
	private Kabupaten kabupaten;
	private String name;
	private String last;
	private String email;
	private Timestamp insertDate;
	private Integer post;
	private String address;
	private String address2;
	private String phone;
	private String password;
	private Set ships = new HashSet(0);
	private Set orders = new HashSet(0);

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** full constructor */
	public Customer(Kabupaten kabupaten, String name, String email,
			Timestamp insertDate, String address, String phone, Set ships,
			Set orders, Integer post, String password, String address2, String last) {
		this.kabupaten = kabupaten;
		this.name = name;
		this.last = last;
		this.email = email;
		this.insertDate = insertDate;
		this.address = address;
		this.phone = phone;
		this.ships = ships;
		this.orders = orders;
		this.post = post;
		this.password = password;
		this.address2 = address2;
	}

	// Property accessors

	public Integer getCustomerId() {
		return this.customerId;
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

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Kabupaten getKabupaten() {
		return this.kabupaten;
	}

	public void setKabupaten(Kabupaten kabupaten) {
		this.kabupaten = kabupaten;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Timestamp insertDate) {
		this.insertDate = insertDate;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set getShips() {
		return this.ships;
	}

	public void setShips(Set ships) {
		this.ships = ships;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

	public Integer getPost() {
		return post;
	}

	public void setPost(Integer post) {
		this.post = post;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}