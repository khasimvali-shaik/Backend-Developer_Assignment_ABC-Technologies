package com.assignment.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.model.Medicine;
import com.assignment.repositories.MedicineRepository;
/*
 * This class is a service class while spring scanning through this class it gets to know that it is a service
 * and manages the whole life cycle by instantiating the bean inside the spring container.
 */
@Service
public class MedicineService {
	
	//This is reference to the repository
	@Autowired
	private MedicineRepository repo;
	


	String line = "";

	public void saveMedicine() {
		try {
			//Reading the csv file form the given location
			BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/Product list - Sheet1.csv"));
			
			//This is to make sure that we dont read the first line from the csv file
			int iteration = 0;
			while ((line = reader.readLine()) != null) {
				//checking the line number of csv file to skip if it is first line
				if (iteration == 0) {
					iteration++;
					continue;
				}
				
				iteration++;
				
				//separating the data into array of strings by splitting at ","
				String[] data = line.split(",");
				
				//collecting the date as string and again splitting it into day, month and year
				String sDate = data[2];
				String[] date = sDate.split("/");
				int day = Integer.parseInt(date[0]);
				int month = Integer.parseInt(date[1]);
				int year = Integer.parseInt(date[2]);

				//converting day, month and year into LocalDate format and for storing into database
				LocalDate date1 = LocalDate.of(year, month, day);
				Medicine medicine = new Medicine();
				
				//Retrieving all the values from the string array and converting into respective types if needed and setting the values to the model
				//Refer the com.assignment.model.Medicine class to get an idea about all the property types
				medicine.setName(data[0]);
				medicine.setBatchNo(data[1]);
				medicine.setExpiryDate(date1);
				medicine.setBalanceQty(Integer.parseInt(data[3]));
				medicine.setPackaging(data[4]);
				medicine.setUniqueCode(data[5]);
				medicine.setSchemes(data[6]);
				medicine.setMrp(Double.parseDouble(data[7]));
				medicine.setManufacturer(data[8]);
				medicine.setHsnCode(data[9]);
				
				//This is the method present inside the repository used to store the data into database
				repo.save(medicine);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//this method takes the string as argument and return List of Medicine names available in the database starting with the given value.
	public List<String> searchMedicine(String value) {
		List<Medicine> medicines = repo.findByNameStartsWith(value);
		List<String> names = new ArrayList<>();
		for (Medicine m : medicines) {
			names.add(m.getName());
		}

		return names;
	}

	//this method takes the string as argument and return List of Medicine objects available in the database by the given id
	public List<Medicine> getMedicines(String id) {
		return repo.findAllByuniqueCode(id);
	}

	//This method is taking two parameters and process them according to the business logic
	public String orderMedicine(String quantity, String uniqueId) {
		//Taking the uniqueId and check if the resource available in database and store all the records inside the medicines bellow
		List<Medicine> medicines = repo.findAllByuniqueCode(uniqueId);
		for (Medicine m : medicines) {
			//By looping through all the available records and checking if the ordered quantity is less than available quantity.
			if (Integer.parseInt(quantity) > m.getBalanceQty()) {
				return "Quantity exceeded";
			}
		}
		//If resource is present and quantity is less than available quantity then generate a unique id using UUID class.
		UUID uuid = UUID.randomUUID();

		return "Your order id is: " + uuid.toString();
	}
	
	public List<Medicine> getAllMedicine() {
		return  repo.findAll();
	}
}
