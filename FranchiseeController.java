package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.dao.AdminReop;
import com.boot.dao.FranchiseeRepo;
import com.boot.dao.TeachersRepo;
import com.boot.entity.Admin;
import com.boot.entity.Franchisee;
import com.boot.entity.Teacher;

@RestController
@RequestMapping("/franchisee")
public class FranchiseeController {

	@Autowired
	FranchiseeRepo  repo;
	
	@Autowired
	AdminReop admRepo;
	
	@Autowired
	TeachersRepo teacherRepo;

	@PostMapping("/add-franchisee/{adminId}")
	public void savedata(@RequestBody Franchisee franchies, @PathVariable String adminId) {
		
		repo.save(franchies);
		
		Admin adm = admRepo.findById(adminId).get();
		franchies.setAdminId(adm);
		
		repo.save(franchies);
	}
	
	@PostMapping("/set-teacher-franchisee/{teacherId}")
	public void savedata1(@RequestBody Franchisee franchies, @PathVariable String teacherId) {
		repo.save(franchies);
		
		Teacher teach = teacherRepo.findById(teacherId).get();
		franchies.setTeacherId(teach);
		
		repo.save(franchies);
	}

	@GetMapping("/show-franchisee")
	public List<Franchisee> showAllData(){
		return repo.findAll();
	}

	@DeleteMapping("/delete-franchisee/{id}")
	public void deletedata(@PathVariable(name="id")String id) {
		repo.deleteById(id);
	}

	@PutMapping("/update-franchisee/{id}")
	public Franchisee updateFranchies(@PathVariable String id, @RequestBody Franchisee newfranchies) {

			return repo.findById(id).map( 
					franchisee ->{
						franchisee.setFranchiesName(newfranchies.getFranchiesName());
						franchisee.setLocation(newfranchies.getLocation());	
						return repo.save(franchisee);
					}
					).orElseGet(
							()->repo.save(newfranchies)
					);
	}
	
	@PutMapping("/update-franchisee-password/{id}")
	public Franchisee updateFranchiesPassword(@PathVariable String  id, @RequestBody Franchisee newfranchisee) {
		return repo.findById(id).map( 
				franchisee ->{			
					franchisee.setPhoneNo(newfranchisee.getPhoneNo());
					return repo.save(franchisee);
				}	
		).orElseGet(
				()->repo.save(newfranchisee)
		);				
	}

	@GetMapping("/franchisee-validation/{userNm}/{pwd}")
	public List<Franchisee> validation(@PathVariable String userNm , @PathVariable long pwd){
		System.out.println(userNm);
		System.out.println(pwd);
		return repo.findByEmailIdAndPhoneNo(userNm, pwd);
	}
	
}