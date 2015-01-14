package com.spinach.dbo;

import java.util.HashSet;
import java.util.Set;

/**
 * Kabupaten entity. @author MyEclipse Persistence Tools
 */

public class Kabupaten implements java.io.Serializable {

	// Fields

	private Integer kabupatenId;
	private Provinsi provinsi;
	private String name;

	// Constructors

	/** default constructor */
	public Kabupaten() {
	}

	/** full constructor */
	public Kabupaten(Provinsi provinsi, String name) {
		this.provinsi = provinsi;
		this.name = name;
	}

	// Property accessors

	public Integer getKabupatenId() {
		return this.kabupatenId;
	}

	public void setKabupatenId(Integer kabupatenId) {
		this.kabupatenId = kabupatenId;
	}

	public Provinsi getProvinsi() {
		return this.provinsi;
	}

	public void setProvinsi(Provinsi provinsi) {
		this.provinsi = provinsi;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}