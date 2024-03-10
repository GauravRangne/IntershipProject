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

import com.boot.dao.FranchiesRepo;
import com.boot.entity.Franchies;
@RestController
public class FranchiesController {
	
	@Autowired
	FranchiesRepo  repo;
	
	
	@PostMapping("/addFranchies")
	public void savedata(@RequestBody Franchies franchies) {
		repo.save(franchies);
		
	}
	
	@GetMapping("/showFranchies")
	public List<Franchies> showAllData(){
		return repo.findAll();
	}
	
	
	@DeleteMapping("/byId/{id}")
	
	public void deletedata(@PathVariable(name="id")int id) {
		repo.deleteById(id);
	}
	
	
	
	@PutMapping("/updatebyId/{id}")
	public Franchies updateFranchies(@PathVariable int id, @RequestBody Franchies newfranchies) {
		//TODO: process PUT request
		
 
			
			return repo.findById(id).map( 
					franchies ->{
						franchies.setFranchiesName(newfranchies.getFranchiesName());
						franchies.setLocation(newfranchies.getLocation());
						franchies.setEmailId(newfranchies.getEmailId());
						franchies.setFranchiesContactInfo(newfranchies.getFranchiesContactInfo());
						
						return repo.save(franchies);
					}
					
					
					).orElseGet(
							()->repo.save(newfranchies)
							
							);
					
		}
	
	
	@GetMapping("/validation/{userNm}/{pwd}")
	public List<Franchies> validation(@PathVariable String userNm , @PathVariable long pwd){
		System.out.println(userNm);
		System.out.println(pwd);
		return repo.findByEmailIdAndFranchiesContactInfo(userNm, pwd);
	}

	

}
