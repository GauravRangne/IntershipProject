package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.dao.PaymentRepo;

import com.boot.entity.Payment;

@RestController
public class PaymentController {
 
	@Autowired
	PaymentRepo repo;
	
	@PostMapping("/addPayment")
	public void  savedata(@RequestBody Payment payment) {
		 repo.save(payment);
	}
	
	@GetMapping("/showPaymentDetails")
	public List<Payment> showAllDetails(){
		return repo.findAll();
	}
	
	@DeleteMapping("/PaymentById/{id}")
	public void deletedata(@PathVariable (name="id") int id){
		repo.deleteById(id);
	}
	
	@PutMapping("/updatePaymentById/{id}")
	public  Payment updateCourses(@PathVariable int id, @RequestBody Payment newpayment) {
		//TODO: process PUT request
		
 
			
			return repo.findById(id).map( 
					payment ->{
						payment.setDateOfPayment(newpayment.getDateOfPayment());
						payment.setPaymentStatus(newpayment.isPaymentStatus());
						payment.setAmount(newpayment.getAmount());
						
						
						return repo.save(payment);
					}
					
					
					).orElseGet(
							()->repo.save(newpayment)
							
							);
					
		}
}
