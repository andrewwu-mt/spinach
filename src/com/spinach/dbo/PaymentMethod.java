package com.spinach.dbo;

import java.util.HashSet;
import java.util.Set;

/**
 * ShipType entity. @author MyEclipse Persistence Tools
 */

public class PaymentMethod implements java.io.Serializable {

	// Fields

	private Integer paymentMethodId;
	private String name;
	private Set ships = new HashSet(0);

	// Constructors

	/** default constructor */
	public PaymentMethod() {
	}

	/** full constructor */
	public PaymentMethod(String name, Set ships) {
		this.name = name;
		this.ships = ships;
	}

	// Property accessors

	public String getName() {
		return this.name;
	}

	public Integer getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(Integer paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getShips() {
		return this.ships;
	}

	public void setShips(Set ships) {
		this.ships = ships;
	}

}