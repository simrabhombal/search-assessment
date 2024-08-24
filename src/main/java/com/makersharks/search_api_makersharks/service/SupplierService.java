package com.makersharks.search_api_makersharks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makersharks.search_api_makersharks.beans.Supplier;
import com.makersharks.search_api_makersharks.repository.SupplierRepository;

@Service
public class SupplierService {
	@Autowired
	private SupplierRepository repo;
	
	public List<Supplier> listAll() {
				return repo.findAll();
	}
	
	public List<Supplier> listAll(String keyword) {
		if (keyword != null) {
			return repo.search(keyword);
		}
		return repo.findAll();
	}
	
	public void save(Supplier product) {
		repo.save(product);
	}
	
	public Supplier get(Long supplier_id) {
		return repo.findById(supplier_id).get();
	}
	
	public void delete(Long supplier_id) {
		repo.deleteById(supplier_id);
	}
	

	
}
