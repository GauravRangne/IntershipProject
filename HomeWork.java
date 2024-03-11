package com.boot.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class HomeWork{
	
	@Id
	private int homeworkid;
	
	@Column(length=20)
	private String title;
	
	private Date duedate;
	

}
