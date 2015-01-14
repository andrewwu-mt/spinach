package com.spinach.dbo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields

	private Integer productId;
	private Type type;
	private String name;
	private String description;
	private Integer priceBox;
	private Integer priceBottle;
	private Timestamp insertDate;
	private Timestamp updateDate;
	private Integer active;
	private String src;
	private Category category;
	private String shortName;
	private String desc;
	private Set stocks = new HashSet(0);
	private Set orders = new HashSet(0);

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** full constructor */
	public Product(Type type, String name, String description,
			Integer priceBox, Integer priceBottle, Timestamp insertDate,
			Timestamp updateDate, Integer active, String src, Set stocks,
			Set orders, Category category, String shortName, String desc) {
		this.type = type;
		this.name = name;
		this.description = description;
		this.priceBox = priceBox;
		this.priceBottle = priceBottle;
		this.insertDate = insertDate;
		this.updateDate = updateDate;
		this.active = active;
		this.src = src;
		this.stocks = stocks;
		this.orders = orders;
		this.category = category;
		this.shortName = shortName;
		this.desc = desc;
	}

	// Property accessors

	public Integer getProductId() {
		return this.productId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPriceBox() {
		return this.priceBox;
	}

	public void setPriceBox(Integer priceBox) {
		this.priceBox = priceBox;
	}

	public Integer getPriceBottle() {
		return this.priceBottle;
	}

	public void setPriceBottle(Integer priceBottle) {
		this.priceBottle = priceBottle;
	}

	public Timestamp getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Timestamp insertDate) {
		this.insertDate = insertDate;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getActive() {
		return this.active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getSrc() {
		return this.src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public Set getStocks() {
		return this.stocks;
	}

	public void setStocks(Set stocks) {
		this.stocks = stocks;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}