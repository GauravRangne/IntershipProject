package com.boot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Entity
@Data
@PrimaryKeyJoinColumn
public class Material {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int materialId;
	
	@Column(length = 15)
	private String category;
	
	private int quantity;
	
	@Column(length = 15)
	private String level;
	
	@ManyToOne
	private Admin adminId;
}
