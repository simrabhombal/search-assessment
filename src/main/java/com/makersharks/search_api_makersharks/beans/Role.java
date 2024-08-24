package com.makersharks.search_api_makersharks.beans;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="role")
public class Role implements GrantedAuthority {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@ManyToMany(mappedBy="roles")
	private Set<User> users;
	
	



	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return name;
	}





	public Role(String name, Set<User> users) {
		super();
		this.name = name;
		this.users = users;
	}

}
