package de.gov.dao;

import org.springframework.stereotype.Repository;



@Repository
public interface AreaDAO {

	/**
	 * 根據區域名稱查詢Id
	 * @param illnesses
	 * @return 返回id
	 */
	 int selectByAreaNameGetId(String result);
	
	
}
