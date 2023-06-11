package com.jspider.hibernate.manytoone_mapping.dto;

import javax.persistence.Entity;  
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class PlayerDTO {
	@Id
	private int ID;
	private String Name;
	private String Roll;
	private String Jersey_No;
	private int Age;
    
	@ManyToOne
	private TemaDTO team;
}
