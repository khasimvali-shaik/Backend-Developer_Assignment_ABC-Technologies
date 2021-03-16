package com.assignment.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.model.Medicine;
import com.assignment.services.MedicineService;

/* This is a rest controller used to handle all the requests came to the server by using handler methods
 * 
 */
@RestController
public class MedicineController {
	//MedicineService bean will be automatically injected by the spring container as it scans the class path and instantiate this class.
	@Autowired
	private MedicineService service;
	
	//This method invokes when the request came for the url "/uploadCSV" and invokes the method inside service.
	@RequestMapping("/uploadCSV")
	public void saveMedicine() {
		
		service.saveMedicine();
		
	}
	
	//This method invokes when the request came for the url "/searchMedicine" by taking parameter inside the url and invokes the method inside service.
	@RequestMapping("/searchMedicine/{value}")
	public List<String> searchMedicine(@PathVariable String value) {
		
		return service.searchMedicine(value);
	}
	
	//This method invokes when the request came for the url "/getMedicineDetails" by taking parameter inside the url and invokes the method inside service.
	@RequestMapping("/getMedicineDetails/{uniqueId}")
	public List<Medicine> getMedicine(@PathVariable String uniqueId){
		return service.getMedicines(uniqueId);
	}
	
	//This method invokes when the request came for the url "/placeorder" by taking parameter inside the url and invokes the method inside service.
	@PostMapping("/placeorder")
	//we get the json object inside the request body and mapping each property to a map bellow
	public String orderMedicine(@RequestBody Map<String, Object> payload) {
		
		
		return service.orderMedicine(payload.get("quantity").toString(),payload.get("c_unique_id").toString());
	}
	
}
