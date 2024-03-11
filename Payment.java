package com.boot.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity 

public class Payment {
       
	@Id
	private int paymentId;
	
	
	private Date dateOfPayment;
	

	private boolean paymentStatus;
	
	@Column(length=20)
	private int amount;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(int paymentId, Date dateOfPayment, boolean paymentStatus, int amount) {
		super();
		this.paymentId = paymentId;
		this.dateOfPayment = dateOfPayment;
		this.paymentStatus = paymentStatus;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", dateOfPayment=" + dateOfPayment + ", paymentStatus="
				+ paymentStatus + ", amount=" + amount + "]";
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public Date getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(Date dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

	public boolean isPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}

