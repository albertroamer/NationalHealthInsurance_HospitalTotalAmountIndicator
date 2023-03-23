package de.gov.dao;

import org.springframework.stereotype.Repository;


import de.gov.entity.DataPCTIndex;

@Repository
public interface DataPCTIndexDAO {

	/**
	 * 插入數據
	 * @param dataPCTIndex 傳入需要插入的entity
	 * @return 返回插入的筆數
	 */
	 int insert(DataPCTIndex dataPCTIndex);
	
	
}
