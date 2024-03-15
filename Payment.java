package com.boot.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Payment {
       
	@Column(unique = true)
	private int paymentId;
	
	@Column
	private Date dateOfPayment;
	
	@Column
	private boolean paymentStatus;
	
	@Column
	private long amount;
}

