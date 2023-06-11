package com.jspiders.hibernsteOnetoOne.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class AdharDTO {

	@Id
	private int id;
	private long adhar_no;
	private String doi;
}
