package com.spinach.dbo;


/**
 * ShipType entity. @author MyEclipse Persistence Tools
 */

public class Exchange implements java.io.Serializable {

	// Fields

	private Integer exchangeId;
	private Integer value;

	// Constructors

	/** default constructor */
	public Exchange() {
	}

	/** full constructor */
	public Exchange(Integer value) {
		this.value = value;
	}

	public Integer getExchangeId() {
		return exchangeId;
	}

	public void setExchangeId(Integer exchangeId) {
		this.exchangeId = exchangeId;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	// Property accessors


}