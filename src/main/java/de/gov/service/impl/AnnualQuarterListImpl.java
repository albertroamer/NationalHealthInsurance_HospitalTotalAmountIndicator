package de.gov.service.impl;

import de.gov.service.IAnnualQuarterListImpl;
import de.gov.vo.AnnualQuarterVO;
import de.gov.dao.AnnualQuarterDAO;

import de.gov.entity.AnnualQuarter;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnnualQuarterListImpl implements IAnnualQuarterListImpl {
	
	@Autowired
	AnnualQuarterDAO AnnualQuarterDAO;
	
	@Override
	public List<AnnualQuarterVO> displayAnnualQuarter() {
		List<AnnualQuarterVO> annual_quarter_list = AnnualQuarterDAO.selectAnnualQuarter();
		return annual_quarter_list;
	}

	
	
}
