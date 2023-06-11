package com.jspiders.onetomany_mapping.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee {
    @Id
	private int Id;
    private String Name;
    @Column(name ="Job")
    private String Designation;
    private String Salary;
}
