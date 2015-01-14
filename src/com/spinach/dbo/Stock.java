package com.spinach.dbo;

/**
 * Stock entity. @author MyEclipse Persistence Tools
 */

public class Stock implements java.io.Serializable {

	// Fields

	private Integer stockId;
	private Product product;
	private Integer number;

	// Constructors

	/** default constructor */
	public Stock() {
	}

	/** full constructor */
	public Stock(Product product, Integer number) {
		this.product = product;
		this.number = number;
	}

	// Property accessors

	public Integer getStockId() {
		return this.stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

}