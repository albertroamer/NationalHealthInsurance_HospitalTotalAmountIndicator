package de.gov.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AnnualQuarterDTO implements Serializable{
	

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

}
