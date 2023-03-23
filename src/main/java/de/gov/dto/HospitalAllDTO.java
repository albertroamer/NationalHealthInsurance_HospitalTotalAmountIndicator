package de.gov.dto;

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
public class HospitalAllDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 編號
	 */
	private Long id;
	/**
	 * 醫院名稱
	 */
	private String hospitalName;
	/**
	 * 醫院所在地區
	 */
	private String countyCity;
	/**
	 * 縣市ID
	 */
	private Integer areaId;
	/**
	 * 醫院代碼ID
	 */
	private String hospitalCodeId;
	/**
	 * 特約類別ID
	 */
	private Integer  appointedId;
	/**
	 * 分子
	 */
	private Integer  numerator;
	/**
	 * 分母
	 */
	private Integer  denominator;
	/**
	 * 所屬分區業務組指標值
	 */
	private Double divIndex;
	/**
	 * 全國指標值
	 */
	private Double nationalIndex;
	/**
	 * 所屬醫院ID
	 */
	private Integer hospitalId;
	/**
	 * 總指標ID
	 */
	private Integer hospItemId;
	/**
	 * 年度季度ID
	 */
	private Integer annualQuarterId;
	
	public HospitalAllDTO(String hospitalName, String countyCity,Integer appointedId,
			Integer numerator, Integer denominator, Double divIndex, Double nationalIndex,Integer hospItemId) {
		super();
		this.hospitalName = hospitalName;
		this.countyCity = countyCity;
		this.appointedId = appointedId;
		this.numerator = numerator;
		this.denominator = denominator;
		this.divIndex = divIndex;
		this.nationalIndex = nationalIndex;
		this.hospItemId = hospItemId;
	}


	
	
	
	
	
}
