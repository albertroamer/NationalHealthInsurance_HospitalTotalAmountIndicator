package de.gov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import de.gov.service.IHospitalDataImpl;

@RestController
public class HospitalDataController {
	
	@Autowired
	IHospitalDataImpl iHospitalDataImpl;
	
	
	@GetMapping("")
	public String insert() {
		iHospitalDataImpl.insert();
		return "OK";
	}
	
	

}
