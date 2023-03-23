package de.gov.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.gov.service.IHospitalNameService;
import de.gov.vo.HospitalNameVO;
import de.gov.dao.HospitalNameDAO;

@Service
public class HospitalNameServiceImpl implements IHospitalNameService {
	
	@Autowired
	HospitalNameDAO HospitalNameDAO;
	
	@Override
	public List<HospitalNameVO> displayHospitalName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
