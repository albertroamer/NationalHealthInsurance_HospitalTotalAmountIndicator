package de.gov.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import de.gov.entity.AnnualQuarter;
import de.gov.vo.AnnualQuarterVO;

//這裡For Insert資料(年度季度) 進DB用 請不要與其他模板共用
//例如顯示於前端的的年度季度 應該再建立一個DAO 提供給前端用

@Repository
public interface AnnualQuarterDAO {
	
	 int insert(AnnualQuarter annualQuarter);

	/**
	 * 查詢年度與季度(用於insert，不能與前端取出共用)
	 * @param 傳入需要比對的年度與季度
	 * @return 返回對應的年度與季度
	 */
	 List<AnnualQuarterVO> select(AnnualQuarter annualQuarter);

	 /*
	  * 查詢所有年度季度(發到前端用)
	  */
	 List<AnnualQuarterVO> selectAnnualQuarter();
	 
}
