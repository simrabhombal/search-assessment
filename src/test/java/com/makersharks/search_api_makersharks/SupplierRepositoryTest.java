package com.makersharks.search_api_makersharks;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.test.annotation.Rollback;

import com.makersharks.search_api_makersharks.beans.Supplier;
import com.makersharks.search_api_makersharks.repository.SupplierRepository;




@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class SupplierRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired	
	private SupplierRepository supplierRepository;
	
	@Test
	public void testCreateSupplier() {
		Supplier supplier = new Supplier("Java Full Web Development","Java Develper","Completed","dfasdf","adsfdfs");	
		Supplier savedsupplier = supplierRepository.save(supplier);
		System.out.println("Task Created Successfully "+supplier);
		assertThat(savedsupplier.getSupplier_id()).isGreaterThan(0);

	}
	

	@Test
	public void testListAllSupplier() {
		Iterable<Supplier> listsupplier = supplierRepository.findAll();
		System.out.println("List has found successfully");
		listsupplier.forEach(supplier -> System.out.println(supplier));
	}
	
	@Test
	public void testGetSupplierById() {
		Supplier supplier = supplierRepository.findById((long) 42).get();
		System.out.println(supplier);
		assertThat(supplier).isNotNull();
	}
	
	@Test
	public void testUpdateSupplierDetails() {
		Supplier supplier = supplierRepository.findById((long) 3).get();
	//	task.setId((long)42);
	//	task.setSupplier_id((long)1);
		supplier.setCompany_name("Wipro");

		supplier.setWebsite("thedot.org");
		supplier.setLocation("India");		
		supplier.setNature_of_business("Software development");
		supplier.setManufacturing_processes("Web development");
		System.out.println("Updated Successfully");
		System.out.println(supplierRepository.save(supplier));

	}
	
	@Test
	public void testDeleteSupplier() {
		Long supplierId = (long) 4;
		supplierRepository.deleteById(supplierId);
		System.out.println("Deleted Successfully");

		
	}
	


}
