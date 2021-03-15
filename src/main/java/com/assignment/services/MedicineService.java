package com.assignment.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.model.Medicine;
import com.assignment.repositories.MedicineRepository;

@Service
public class MedicineService {
	
	@Autowired
	private MedicineRepository repo;
	
	String line = "";
	public void saveMedicine() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/Product list - Sheet1.csv"));
			int iteration = 0;
			while((line=reader.readLine())!=null) {
				if(iteration  == 0) {
			        iteration++;  
			        continue;
			    }
				iteration++;
				String[] data = line.split(",");
				String sDate=data[2];  
				
			
				LocalDate date = LocalDate.parse("2018-09-16");
				Medicine medicine = new Medicine();
				medicine.setName(data[0]);
				medicine.setBatchNo(data[1]);
				medicine.setExpiryDate(date);
				medicine.setBalanceQty(Integer.parseInt(data[3]));
				medicine.setPackaging(data[4]);
				medicine.setUniqueCode(data[5]);
				medicine.setSchemes(data[6]);
				medicine.setMrp(Double.parseDouble(data[7]));
				medicine.setManufacturer(data[8]);
				medicine.setHsnCode(data[9]);
				
				repo.save(medicine);
				
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
