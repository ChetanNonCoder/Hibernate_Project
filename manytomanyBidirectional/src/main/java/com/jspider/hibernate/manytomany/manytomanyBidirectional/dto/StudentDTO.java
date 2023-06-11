package com.jspider.hibernate.manytomany.manytomanyBidirectional.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "Std")
public class StudentDTO {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String address;
	
	@ManyToMany
	List<SubjectDTO> Subjects;
}
