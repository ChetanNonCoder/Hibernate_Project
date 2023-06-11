package com.jspider.hibernate.manytomany.manytomanyBidirectional.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "Subs")
public class SubjectDTO {

	@Id
	private int Id;
	private String name;
	private int duration;
	
	@ManyToMany(mappedBy = "Students")
	private List<StudentDTO> Students;
}
