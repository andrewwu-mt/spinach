package com.spinach.dbo;

import java.util.HashSet;
import java.util.Set;

/**
 * Provinsi entity. @author MyEclipse Persistence Tools
 */

public class Provinsi implements java.io.Serializable {

	// Fields

	private Integer provinsiId;
	private String name;
	private Set kabupatens = new HashSet(0);

	// Constructors

	/** default constructor */
	public Provinsi() {
	}

	/** minimal constructor */
	public Provinsi(String name) {
		this.name = name;
	}

	/** full constructor */
	public Provinsi(String name, Set kabupatens) {
		this.name = name;
		this.kabupatens = kabupatens;
	}

	// Property accessors

	public Integer getProvinsiId() {
		return this.provinsiId;
	}

	public void setProvinsiId(Integer provinsiId) {
		this.provinsiId = provinsiId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getKabupatens() {
		return this.kabupatens;
	}

	public void setKabupatens(Set kabupatens) {
		this.kabupatens = kabupatens;
	}

}