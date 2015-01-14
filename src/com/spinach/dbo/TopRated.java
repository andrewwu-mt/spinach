package com.spinach.dbo;

import java.util.List;

/**
 * TopRated entity. @author MyEclipse Persistence Tools
 */

public class TopRated implements java.io.Serializable {

	// Fields

	private TopRatedId id;
	private Integer rank;
	private List<String> onList;
	private List<String> offList;

	// Constructors

	/** default constructor */
	public TopRated() {
	}

	/** full constructor */
	public TopRated(TopRatedId id, Integer rank, List<String> onList, List<String> offList) {
		this.id = id;
		this.rank = rank;
		this.onList = onList;
		this.offList = offList;
	}

	public TopRatedId getId() {
		return id;
	}

	public void setId(TopRatedId id) {
		this.id = id;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public List<String> getOnList() {
		return onList;
	}

	public void setOnList(List<String> onList) {
		this.onList = onList;
	}

	public List<String> getOffList() {
		return offList;
	}

	public void setOffList(List<String> offList) {
		this.offList = offList;
	}

}