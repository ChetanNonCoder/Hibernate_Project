package com.jspider.hibernate.manytoone_mapping.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class TemaDTO {

	@Id
	private int ID;
	private String Name;
	private String City;
}
