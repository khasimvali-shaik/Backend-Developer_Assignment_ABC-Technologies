package com.assignment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.model.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, String> {
	
	List<Medicine> findByNameStartsWith(String rating);
	List<Medicine> findAllByuniqueCode(String uniqueId);

}
