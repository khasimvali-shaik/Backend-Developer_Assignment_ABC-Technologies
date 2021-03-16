package com.assignment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.model.Medicine;
import com.assignment.services.MedicineService;

@RestController
public class MedicineController {
	
	@Autowired
	private MedicineService service;
	
	
	@RequestMapping("/uploadCSV")
	public void saveMedicine() {
		
		service.saveMedicine();
		
	}
	
	@RequestMapping("/searchMedicine/{value}")
	public List<String> searchMedicine(@PathVariable String value) {
		
		return service.searchMedicine(value);
	}
	
	

}
