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
public class DataPCTIndex  implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	/**
	 * 編號
	 */
	private Long id;
	
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
	private Long hospitalId;
	/**
	 * 總指標ID
	 */
	private Integer hospItemId;
	/**
	 * 年度季度ID
	 */
	private Integer annualQuarterId;


}
