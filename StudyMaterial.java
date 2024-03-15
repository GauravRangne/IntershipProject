package com.boot.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class StudyMaterial {
	
	@Id
	private int studyMaterialId;
	
	@Column(length = 50)
	private String studyMaterialName;
	
	private String studyMaterialDetails;
	
	private Date submitDate;
	
	@Column(length=30)
    private String password;


}