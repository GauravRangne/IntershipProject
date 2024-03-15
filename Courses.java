package com.boot.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity
@PrimaryKeyJoinColumn
public class Courses {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int courseId;
       
    @Column(length=50)
	private String courseName;
       
	private String courseDescription;

    private int courseDuration;
	
	@ManyToOne
    private Admin adminId;

	@ManyToMany(mappedBy ="course")
	private Set<Teacher> teacher= new HashSet<>();
	
	@ManyToMany(mappedBy ="course")
	private Set<Student> student= new HashSet<>();
}
