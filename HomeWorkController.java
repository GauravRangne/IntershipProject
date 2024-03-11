package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.boot.dao.HomeWorkRepo;
import com.boot.entity.HomeWork;


public class HomeWorkController {
	
	@Autowired
	HomeWorkRepo repo;
	
	@PostMapping("/addhomework")
	public void savedata(@RequestBody HomeWork homework) {
		repo.save(homework);
		
	}
	
	@GetMapping("/showhomework")
	public List<HomeWork> showAllData(){
		return repo.findAll();
	}
	
	
	@DeleteMapping("/byHomeworkId/{id}")
	
	public void deletedata(@PathVariable(name="id")int id) {
		repo.deleteById(id);
	}
	
	
	
	@PutMapping("/updatebyHomeworkId/{id}")
	public HomeWork updatehomeWork(@PathVariable int id, @RequestBody HomeWork newhomework) {
		//TODO: process PUT request
		
 
			
			return repo.findById(id).map( 
					homeWork ->{
						homeWork.setTitle(newhomework.getTitle());
						homeWork.setDuedate(newhomework.getDuedate());
						
						return repo.save(homeWork);
					}
					
					
					).orElseGet(
							()->repo.save(newhomework)
							
							);
					
		}
	
	

}
