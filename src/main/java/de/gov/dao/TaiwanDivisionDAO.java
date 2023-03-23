package de.gov.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import de.gov.vo.TaiwanDivisionVO;

@Repository
public interface TaiwanDivisionDAO {
	 /*
	  * 查詢分區業務組
	  */
	 List<TaiwanDivisionVO> searchDivision();
	 
}
