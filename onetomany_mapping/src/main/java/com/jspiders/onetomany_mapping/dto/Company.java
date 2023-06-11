package com.jspiders.onetomany_mapping.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Company {
	@Id
	private int id;
	@Column(name = "Cname")
	private String Name;
	private String Doe;
	@Column(name = "Address")
	private String Add;
	@OneToMany
	List<Employee> emp;
}
