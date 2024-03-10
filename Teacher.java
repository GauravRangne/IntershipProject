package com.boot.entity;



import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Teacher {
	@Id
	private int teachersId;
	@Column(length = 30)
	
	private String teacherNm;
	@Column(length = 30)
	
	private String teacherEmail;
	@Column(length = 60)
	
	private long mobileNo;
	@Column(length = 30)
	
	private String salary;
	@Column(length = 30)
	
	private String subject;
	@Column(length = 30)
	
	private Date joiningDate;
	@Column(length = 30)
	private int branchId;
	
	private String frenchie;
	@Column(length = 30)
	
	private int batchNo;
	
	private String password;
	
	
	

	
	
	
	
	

}
