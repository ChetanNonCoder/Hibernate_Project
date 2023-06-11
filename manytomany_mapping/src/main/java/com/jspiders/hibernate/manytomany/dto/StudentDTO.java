package com.jspiders.hibernate.manytomany.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class StudentDTO   {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String Name;
	private String Email;
	private String Address;
	
	@ManyToMany
	
	List<SubjectDTO> Subject; 
}
