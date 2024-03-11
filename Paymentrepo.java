package com.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.entity.Payment;
@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer>{

	

	
}
