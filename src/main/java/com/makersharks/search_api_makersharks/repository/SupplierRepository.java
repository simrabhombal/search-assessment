package com.makersharks.search_api_makersharks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.makersharks.search_api_makersharks.beans.Supplier;


public interface SupplierRepository extends JpaRepository<Supplier, Long> {
		
	@Query("SELECT j FROM Supplier j WHERE CONCAT(j.supplier_id, ' ',j.company_name, ' ', j.website, ' ', j.location,' ', j.nature_of_business,' ', j.manufacturing_processes) LIKE %?1%")
	public List<Supplier> search(String keyword);


//	Optional<Product> findById(long id);
	
}