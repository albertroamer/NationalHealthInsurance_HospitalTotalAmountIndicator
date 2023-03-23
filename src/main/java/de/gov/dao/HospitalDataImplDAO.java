package de.gov.dao;

import java.util.List;

import org.springframework.stereotype.Repository;


import de.gov.entity.HospitalData;
import de.gov.vo.HospitalAllVO;

@Repository
public interface HospitalDataImplDAO {

	/**
	 * 新增各季度資料
	 * @param illnesses
	 * @return 返回成功的筆數
	 */
	 int insert(HospitalData hospitalData );
	 
	 List<HospitalAllVO> selectHospitalName(String hospitalName,String countyCity);
	 
	 List<HospitalAllVO> selectAllData();
}
