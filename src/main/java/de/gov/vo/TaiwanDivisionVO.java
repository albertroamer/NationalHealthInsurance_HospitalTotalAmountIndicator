package de.gov.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class TaiwanDivisionVO implements Serializable{
	
	/**
	 * 編號
	 */
	private Integer id;
	/**
	 * 業務分組
	 */
	private String division;


}
