package de.gov.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class AnnualQuarter implements Serializable{
	
	/**
	 * 編號
	 */
	private Integer id;
	
	/**
	 * 年度
	 */
	private Integer annual;
	/**
	 * 季度
	 */
	private String quarter;
	
	public AnnualQuarter(Integer annual, String quarter) {
		super();
		this.annual = annual;
		this.quarter = quarter;
	}

	public AnnualQuarter() {
		super();
		// TODO Auto-generated constructor stub
	}

}
