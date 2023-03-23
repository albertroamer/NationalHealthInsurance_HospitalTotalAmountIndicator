package de.gov.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class CityVO implements Serializable{

	/*
	 * 城市id
	 */
	private Long areaId;
	/*
	 * 查詢城市
	 */
	private String areaName;
	/*
	 * 縣市區域關聯鍵
	 */
	private Integer countyForeignKey;
	
}
