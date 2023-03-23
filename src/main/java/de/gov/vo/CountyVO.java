package de.gov.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class CountyVO implements Serializable{
	/**
	 * 縣市id
	 */
	private Integer countyId;
	/**
	 * 查詢縣市
	 */
	private String countyName;
	
}
