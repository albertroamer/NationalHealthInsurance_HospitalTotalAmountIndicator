package de.gov.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import de.gov.vo.CountyVO;
import de.gov.vo.CityVO;

@Repository
public interface CountyCityDAO {
	 /*
	  * 查詢縣市區別
	  */
	 List<CountyVO> selectCounty();
	 List<CityVO> selectCity(Long id); 
}
