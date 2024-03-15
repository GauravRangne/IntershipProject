package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.dao.AdminReop;
import com.boot.entity.Admin;

//@CrossOrigin("http://localhost:4200")
@RequestMapping("/admin")
@RestController
public class AdminController {

	@Autowired
	private AdminReop repo;
	
	@PostMapping("/add-admin")
	public ResponseEntity<String> addAdmin(@RequestBody Admin admin) {
		System.out.println("In the method add.");
		repo.save(admin);
		return ResponseEntity.status(HttpStatus.OK)
                .body("Data Transfered");
	}
	
	@GetMapping("/show-admin")
	public List<Admin> showAllAdmin() {
		return repo.findAll();
	}
	
	@DeleteMapping("/delete-admin/{adminId}")
	public void deleteAdmin(@PathVariable String adminId) {
		repo.deleteById(adminId);
	}
	
	@PutMapping("/update-admin/{id}")
	public Admin updateAdmin(@PathVariable String  id, @RequestBody Admin newadmin) {
		return repo.findById(id).map( 
				admin ->{
					admin.setAdminName(newadmin.getAdminName());
					return repo.save(admin);
				}	
		).orElseGet(
				()->repo.save(newadmin)
		);				
	}
	
	@PutMapping("/update-admin-password/{id}")
	public Admin updateAdminPassword(@PathVariable String  id, @RequestBody Admin newadmin) {
		return repo.findById(id).map( 
				admin ->{			
					admin.setPhoneNo(newadmin.getPhoneNo());
					return repo.save(admin);
				}	
		).orElseGet(
				()->repo.save(newadmin)
		);				
	}
	
	@GetMapping("/admin-validation/{adminNm}/{pwd}")
	public List<Admin> validation(@PathVariable String email, @PathVariable long pwd){
		System.out.println(email);
		System.out.println(pwd);
		return repo.findByEmailIdAndPhoneNo(email, pwd);
	}
}
