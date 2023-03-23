package de.gov.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.gov.vo.CityVO;
import de.gov.vo.CountyVO;



/**
 * 慢性病開立慢性病連續處方簽百分比
 *
 * @author Albert
 * @version 0.0.1
 */

public interface ICountyCityImpl {
	
	public List<CountyVO> displayCounty();
	public List<CityVO> displayCity(Long id);
//	public Map<String,List> CountyCityMap();
}
