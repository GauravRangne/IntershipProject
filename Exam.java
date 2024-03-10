package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Exam {
	
	@Id
	private int ExamID;
	
	private Date ExamDate;
	
	private int Duration;
	
	private int TotalMarks;
	
	private int PassingMarks;
	
	@Column(length=20)
	private String ExamTopic;

}
