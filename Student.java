package com.boot.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Entity
@Data
@PrimaryKeyJoinColumn
public class Student extends User{
	
	
	@Column(length=10)
	private String firstName;
	
	@Column(length=10)
	private String middleName;
	
	@Column(length=10)
	private String lastName;
	
	private String address;
	
	private int studentAge;
	
	private Date admissionDate;
	
	@Embedded
	private Exam exam;
	
	@ManyToOne
	private Teacher teacherId;
	
	@OneToMany(mappedBy = "studentId", cascade = CascadeType.ALL)
	private List<Attendance> attendance;
	
	@ManyToOne
	private Batches batchId;
	
	@ManyToMany
	@JoinTable(name= "studentCourse",
	joinColumns= @JoinColumn(name = "studentId"),
	inverseJoinColumns= @JoinColumn(name="courseId")
	)
	private Set<Courses> course = new HashSet<>();
	
}