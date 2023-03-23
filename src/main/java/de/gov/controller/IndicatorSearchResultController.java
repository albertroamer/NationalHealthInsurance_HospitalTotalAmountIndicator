package de.gov.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.gov.service.IAnnualQuarterListImpl;
import de.gov.service.ICountyCityImpl;
import de.gov.service.IHospitalNameService;
import de.gov.service.ITaiwanDivisionImpl;
import de.gov.service.impl.HospitalDataImpl;
import de.gov.vo.AnnualQuarterVO;
import de.gov.vo.CountyVO;
import de.gov.vo.HospitalNameVO;
import de.gov.vo.CityVO;
import de.gov.vo.TaiwanDivisionVO;
import lombok.extern.slf4j.Slf4j;

//@Slf4j
@RestController
public class IndicatorSearchResultController {
	
	Logger logger = LogManager.getLogger(IndicatorSearchResultController.class);
	@Autowired
	IAnnualQuarterListImpl IAnnualQuarterListImpl;
	@Autowired
	ITaiwanDivisionImpl ITaiwanDivisionImpl;
	@Autowired
	ICountyCityImpl ICountyCityImpl;
	@Autowired
	IHospitalNameService IHospitalNameService;

//	@GetMapping("/indicator")
//	public HashMap<String,List> Display_All_Options_HashMap() {
//		
//		HashMap<String,List> Display_All_Options_HashMap = new HashMap<String,List>();
//		//1.Annual Quarter 年度季度資料
//		List<AnnualQuarterVO> AnnualQuarterList = IAnnualQuarterListImpl.displayAnnualQuarter();
//		Display_All_Options_HashMap.put("annualquarter", AnnualQuarterList);
//		//2.Taiwan Division 分區業務組 資料
//		List<TaiwanDivisionVO> TaiwanDivisionList = ITaiwanDivisionImpl.displayDivision();
//		Display_All_Options_HashMap.put("taiwandivision", TaiwanDivisionList);
//		//3.Country City 縣市鄉鎮區別 資料
//		
//		//4.
//		
//		//5.
//		/*
//		logger
//		for (AnnualQuarterVO annualQuarterVO : AnnualQuarterList) {
//			logger.info(annualQuarterVO);
//			System.out.println(annualQuarterVO);
//		}
//		*/
//		return Display_All_Options_HashMap;
//	}

	
	@GetMapping("/indicator/dataAnnualQuarter")
	public List<AnnualQuarterVO> search() {
		List<AnnualQuarterVO> AnnualQuarterList = IAnnualQuarterListImpl.displayAnnualQuarter();
		for (AnnualQuarterVO annualQuarterVO : AnnualQuarterList) {
			logger.info(annualQuarterVO);
			System.out.println(annualQuarterVO);
		}
		return AnnualQuarterList;
	}
	
	@GetMapping("/indicator/dataDivision")
	public List<TaiwanDivisionVO> searchDivision() {
		List<TaiwanDivisionVO> displayDivisionList = ITaiwanDivisionImpl.displayDivision();
		return displayDivisionList;
	}
	
//	@GetMapping("/indicator/dataCountyCity")
//	public Map<String,List> selectCountyCity() {
//		Map<String,List> displayCountyCity = ICountyCityImpl.CountyCityMap();
//		return displayCountyCity;
//	}
	
	@GetMapping("/indicator/dataCounty")
	public List<CountyVO> selectCounty() {
		List<CountyVO> displayCounty = ICountyCityImpl.displayCounty();
		return displayCounty;
	}
	
	@GetMapping("/indicator/dataCounty/{cityId}")
	public List<CityVO> selectCity(@PathVariable("cityId") Long cityID) {
		List<CityVO> displayCity = ICountyCityImpl.displayCity(cityID);
		return displayCity;
	}
//	@GetMapping("/indicator/{id}")
//	public String postFoos(@PathVariable String id) {
//	    return "Post some Foos" + id;
//	}
	

	
//	@PostMapping("/indicator")
//	public List<AnnualQuarterVO> search() {
//		List<AnnualQuarterVO> AnnualQuarterList = IAnnualQuarterListImpl.displayAnnualQuarter();
//		for (AnnualQuarterVO annualQuarterVO : AnnualQuarterList) {
//			logger.info(annualQuarterVO);
//			System.out.println(annualQuarterVO);
//		}
//	
//		return AnnualQuarterList;
//	}
	
//	
//	@GetMapping("/indicator")
//	public List<TaiwanDivisionVO> searchDivision( @RequestParam String type) {
//		List<TaiwanDivisionVO> displayDivisionList = ITaiwanDivision.displayDivision();
//		return displayDivisionList;
//	}
	
	@GetMapping("/indicator/hospitalName")
	public List<HospitalNameVO> selectHostpitalName(@RequestBody String Hosp_Name){
		List<HospitalNameVO> displayHospitalName = IHospitalNameService.displayHospitalName();
		return displayHospitalName;
	}
	
}
