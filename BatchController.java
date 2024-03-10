package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BatchRepo;
import com.example.demo.entity.Batch;

@RestController
@CrossOrigin("http://localhost:4200")
public class BatchController {
	
	@Autowired
	private BatchRepo repo;
	
	@PostMapping("/addbatch")
	public void addbatch(@RequestBody Batch batch) {
		repo.save(batch);
	}
	
	@GetMapping("/showallbatch")
	public List<Batch> showAllBatch() {
		return repo.findAll();
	}
	
	@DeleteMapping("/deletebatch/{}")
	public void deleteProduct(@PathVariable int bId) {
		repo.deleteById(bId);
	}
	
	@PutMapping("/updatebyId/{batchid}")
	public Batch updateBatch(@PathVariable int id, @RequestBody Batch newbatch) {
		//TODO: process PUT request
		
 
			
			return repo.findById(id).map( 
					batch ->{
						batch.setClassroomName(newbatch.getClassroomName());
						batch.setClassSchedule(newbatch.getClassSchedule());
						batch.setGrades(newbatch.getGrades());
						
						return repo.save(batch);
					}
					
					
					).orElseGet(
							()->repo.save(newbatch)
							
							);
					
		}

}
