package com.assignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.services.MedicineService;

@RestController
public class MedicineController {
	
	@Autowired
	private MedicineService service;
	
	
	@RequestMapping("/uploadCSV")
	public void saveMedicine() {
		
		service.saveMedicine();
		
	}

}
