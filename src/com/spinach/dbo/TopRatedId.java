package com.spinach.dbo;

/**
 * TopRated entity. @author MyEclipse Persistence Tools
 */

public class TopRatedId implements java.io.Serializable {

	// Fields

	private Product product;

	// Constructors

	/** default constructor */
	public TopRatedId() {
	}

	public TopRatedId(Product product) {
		this.product = product;
	}

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
		if (!(other instanceof TopRatedId))
			return false;
		TopRatedId castOther = (TopRatedId) other;

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