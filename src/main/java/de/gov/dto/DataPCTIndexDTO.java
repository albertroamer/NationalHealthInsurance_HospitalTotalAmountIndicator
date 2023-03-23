package de.gov.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 *
 * @author Joyce
 * @version 0.0.1
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DataPCTIndexDTO  implements Serializable{
	
	
	
	private static final long serialVersionUID = 1L;
	/**
	 * 編號
	 */
	private Long id;
	
	/**
	 * 分子
	 */
	private Integer pharmacyCase;
	/**
	 * 分母
	 */
	private Integer hospPharmacy;
	
	/**
	 * 所屬分區業務組指標值
	 */
	private Double divIndex;
	/**
	 * 全國指標值
	 */
	private Double nationalIndex;
	
	/**
	 * 每筆資料對應的醫院id
	 */
	private Long hospitalId;
	
	
	public DataPCTIndexDTO(Integer pharmacyCase, Integer hospPharmacy, Double divIndex, Double nationalIndex) {
		
		this.pharmacyCase = pharmacyCase;
		this.hospPharmacy = hospPharmacy;
		this.divIndex = divIndex;
		this.nationalIndex = nationalIndex;
	}

}
