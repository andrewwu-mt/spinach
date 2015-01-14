package com.spinach.dbo;


/**
 * BestSeller entity. @author MyEclipse Persistence Tools
 */

public class BestSellerId implements java.io.Serializable {

	// Fields

	private Product product;

	// Constructors

	/** default constructor */
	public BestSellerId() {
	}

	/** full constructor */
	public BestSellerId(Product product) {
		this.product = product;
	}

	// Property accessors

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BestSellerId))
			return false;
		BestSellerId castOther = (BestSellerId) other;

		return ((this.getProduct() == castOther.getProduct()) || (this.getProduct() != null
				&& castOther.getProduct() != null && this.getProduct().equals(
				castOther.getProduct())));
	}
	
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getProduct() == null ? 0 : this.getProduct().hashCode());
		return result;
	}

}