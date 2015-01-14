package com.spinach.dbo;

/**
 * BestSeller entity. @author MyEclipse Persistence Tools
 */

public class BestSeller implements java.io.Serializable {

	// Fields

	private BestSellerId id;

	// Constructors

	/** default constructor */
	public BestSeller() {
	}

	/** full constructor */
	public BestSeller(BestSellerId id) {
		this.id = id;
	}

	public BestSellerId getId() {
		return id;
	}

	public void setId(BestSellerId id) {
		this.id = id;
	}

}