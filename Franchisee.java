package com.boot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Entity
@Data
@PrimaryKeyJoinColumn
public class Franchisee extends User{

	@Column(length=80)
	private String franchiesName;
	
	@Column(length=50)
	private String location;

	@ManyToOne()
	private Admin adminId;
	
	@ManyToOne()
	private Teacher teacherId;

	@Override
	public String toString() {
		return "Franchisee [franchiesName=" + franchiesName + ", location=" + location + ", adminId=" + adminId
				+ ", teacherId=" + teacherId + "]";
	}
	
	
}
