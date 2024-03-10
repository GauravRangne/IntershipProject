package com.boot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity

public class Courses {
       @Id
	private int courseId;
       
       @Column(length=90)
	private String courseName;
       
    
	
       @Column(length=90)
	private String CourseDescription;
	
       @Column(length=60)
	private int courseDuration;

	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Courses(int courseId, String courseName,  String courseDescription, int courseDuration) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		CourseDescription = courseDescription;
		this.courseDuration = courseDuration;
	}

	@Override
	public String toString() {
		return "Courses [courseId=" + courseId + ", courseName=" + courseName + ",  CourseDescription=" + CourseDescription + ", courseDuration=" + courseDuration + "]";
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}



	public String getCourseDescription() {
		return CourseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		CourseDescription = courseDescription;
	}

	public int getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}

	 
       
       
}
