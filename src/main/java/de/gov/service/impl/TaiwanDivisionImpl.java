package de.gov.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.gov.dao.TaiwanDivisionDAO;
import de.gov.service.ITaiwanDivisionImpl;
import de.gov.vo.AnnualQuarterVO;
import de.gov.vo.TaiwanDivisionVO;

@Service
public class TaiwanDivisionImpl implements ITaiwanDivisionImpl{
	
	@Autowired
	TaiwanDivisionDAO TaiwanDivisionDAO;

	@Override
	public List<TaiwanDivisionVO> displayDivision() {
		
		List<TaiwanDivisionVO> displayDivision = TaiwanDivisionDAO.searchDivision();
		return displayDivision;
	}


}
