package com.makersharks.search_api_makersharks.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name="supplier")
public class Supplier {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="supplier_id")
	private Long supplier_id;
	
	@Column(name="company_name")
	private	String company_name; //job title
	
	@Column(name="website")
	private	String website;
	
	@Column(name="location")
	private	String location;
	
	@Column(name="nature_of_business")
	private	String nature_of_business;
	
	@Column(name="manufacturing_processes")
	private	String manufacturing_processes;

	public Supplier() {
		super();
	}

	public Supplier(String company_name, String website, String location, String nature_of_business,
			String manufacturing_processes) {
		super();
		this.company_name = company_name;
		this.website = website;
		this.location = location;
		this.nature_of_business = nature_of_business;
		this.manufacturing_processes = manufacturing_processes;
	}

	
}
