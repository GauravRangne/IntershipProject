package com.boot.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Admin extends User{

	@Column(length = 30)
	private String adminName;
	
	@OneToMany(mappedBy = "adminId", cascade = CascadeType.ALL)
	private List<Franchisee> franchisee;
	
	@OneToMany(mappedBy = "adminId", cascade = CascadeType.ALL)
	private List<Courses> course;
	
}
