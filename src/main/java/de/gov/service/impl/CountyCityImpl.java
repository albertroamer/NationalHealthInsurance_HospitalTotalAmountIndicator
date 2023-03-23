package de.gov.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.gov.service.ICountyCityImpl;
import de.gov.vo.CountyVO;
import de.gov.vo.CityVO;
import de.gov.dao.CountyCityDAO;



@Service
public class CountyCityImpl implements ICountyCityImpl{
	
	@Autowired
	CountyCityDAO CountyCityDAO;

	@Override
	public List<CountyVO> displayCounty() {
		// TODO Auto-generated method stub
		List<CountyVO> CountyData = CountyCityDAO.selectCounty();
		return CountyData;
	}
	
	@Override
	public List<CityVO> displayCity(Long id) {
		// TODO Auto-generated method stub
		List<CityVO> CityData = CountyCityDAO.selectCity(id);
		return CityData;
	}

//	@Override
//	public Map<String,List> CountyCityMap() {
//		
//		Map<String,List> CountyCityImplMap = new HashMap<String,List>();
//		
//		List<CountyCityVO> CountyData = CountyCityDAO.searchCounty();
//		CountyCityImplMap.put("county", CountyData);
//		List<CountyCityVO> CityData = CountyCityDAO.searchCity();
//		CountyCityImplMap.put("city", CityData);
//		return CountyCityImplMap;
//	}


}
