package com.boot.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Assignment{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int assignmentId;
	
	@Column(length=20)
	private String studentNm;
	
	private String assignmentDetails;
	
	private Date asignDate;
	
}
