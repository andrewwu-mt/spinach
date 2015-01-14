package com.spinach.dbo;

import java.util.HashSet;
import java.util.Set;

/**
 * ShipType entity. @author MyEclipse Persistence Tools
 */

public class ShipType implements java.io.Serializable {

	// Fields

	private Integer shipTypeId;
	private String name;
	private Set ships = new HashSet(0);

	// Constructors

	/** default constructor */
	public ShipType() {
	}

	/** minimal constructor */
	public ShipType(String name) {
		this.name = name;
	}

	/** full constructor */
	public ShipType(String name, Set ships) {
		this.name = name;
		this.ships = ships;
	}

	// Property accessors

	public Integer getShipTypeId() {
		return this.shipTypeId;
	}

	public void setShipTypeId(Integer shipTypeId) {
		this.shipTypeId = shipTypeId;
	}

	public String getName() {
		return this.name;
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