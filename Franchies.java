package com.boot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Franchies {
	
	@Id
	 private int franchiesId;

	@Column(length=80)
	 private String franchiesName;
	 @Column(length=50)
	 private String location;
	 @Column(length = 50)
	 private String emailId;
	 @Column(length=10)
	 private  long franchiesContactInfo;
	 @Column(length = 30)
	 private String password;
	 

	 
	 
	 
}
