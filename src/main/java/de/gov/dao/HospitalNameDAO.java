package de.gov.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import de.gov.vo.HospitalNameVO;

@Repository
public interface HospitalNameDAO {

	
	/*
	 * 查詢醫事院所名稱
	 */
	List<HospitalNameVO> selectHospitalName();
}
