package com.boot.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Batches{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int batchId;
	
	@Column(length=30)
	private String classroomName;
	
	private Date classSchedule;
	
	@Column(length=10)
	private String grades;
	
	@OneToMany(mappedBy ="batchId", cascade = CascadeType.ALL)
	private List<Student> student;
}
