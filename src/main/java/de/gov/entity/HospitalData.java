package de.gov.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 慢性病開立慢性病連續處方簽百分比
 *
 * @author Joyce
 * @version 0.0.1
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HospitalData implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 編號
	 */
	private Long id;
	
	private String hospitalName;
	
	private String countyCity;
	
	private Integer areaId;
	
	private String hospitalCodeId;
	
	private Integer  appointedId;
	
	/**
	 * 返回的ID行數
	 */
	private Long tempId;
	

	
	
	
	
}
