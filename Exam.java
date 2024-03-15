package com.boot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Exam {
	
	@Column
	private boolean level1;
	
	@Column
	private boolean level2;
	
	@Column
	private boolean level3;
	
	@Column
	private boolean level4;
	
	@Column
	private boolean level5;
	
	@Column
	private boolean level6;

	@Column
	private boolean level7;
	
	@Column
	private boolean level8;
	
	@Column
	private boolean level9;
}
