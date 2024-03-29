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
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Teacher extends User {
	
	@Column(length = 30)	
	private String teacherNm;
	
	private double salary;
	
	@Column(length = 20)
	private String subject;
	
	private Date joiningDate;
	
	@Embedded
	private Payment payment;

	@OneToMany(mappedBy = "teacherId", cascade = CascadeType.ALL)
	private List<Franchisee> franchisee;
	
	@OneToMany(mappedBy = "teacherId", cascade = CascadeType.ALL)
	private List<Student> student;
	
	@OneToMany(mappedBy = "teacherId", cascade = CascadeType.ALL)
	private List<Attendance> attendance;

	@ManyToMany
	@JoinTable(name= "teacherCourse",
	joinColumns= @JoinColumn(name = "teacherId"),
	inverseJoinColumns= @JoinColumn(name="courseId")
	)
	private Set<Courses> course = new HashSet<>();
}
