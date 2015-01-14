package com.spinach.dbo;

/**
 * Kecamatan entity. @author MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

	// Fields

	private Integer categoryId;
	private String name;
	private Type type;

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** full constructor */
	public Category(String name, Type type) {
		this.name = name;
		this.type = type;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}