package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name="Batches")
public class Batch {
	
	@Column(length=30)
	private String ClassroomName;
	
	private Date ClassSchedule;
	
	@Column(length=10)
	private String Grades;
	
	@Id
	private int BatchCode;
	
}
