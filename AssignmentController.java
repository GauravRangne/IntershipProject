package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.boot.dao.AssignmentRepo;
import com.boot.entity.Assignment;

public class AssignmentController {
	
	@Autowired
	AssignmentRepo repo;
	
	@PostMapping("/add-assignment")
	public void savedata(@RequestBody Assignment assignment) {
		repo.save(assignment);	
	}
	
	@GetMapping("/show-assignment")
	public List<Assignment> showAllData(){
		return repo.findAll();
	}	
	
	@DeleteMapping("/delete-assignment/{id}")
	public void deletedata(@PathVariable(name="id")int id) {
		repo.deleteById(id);
	}	
	
	@PutMapping("/update-assignment/{id}")
	public Assignment updatehomeWork(@PathVariable int id, @RequestBody Assignment newassignment) {
			return repo.findById(id).map( 
				assignment ->{
					assignment.setTitle(newassignment.getTitle());
					assignment.setDuedate(newassignment.getDuedate());
					assignment.setAssignmentDetails(newassignment.getAssignmentDetails());
					return repo.save(assignment);
			}
			).orElseGet(
				()->repo.save(newassignment)	
			);					
	}
	
}
