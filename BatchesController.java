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

import com.boot.dao.BatchesRepo;
import com.boot.entity.Batches;

//@CrossOrigin("http://localhost:4200")
@RequestMapping("/batches")
@RestController
public class BatchesController {
	
	@Autowired
	private BatchesRepo repo;
	
	@PostMapping("/add-batch")
	public void addbatch(@RequestBody Batches batch) {
		repo.save(batch);
	}
	
	@GetMapping("/show-batches")
	public List<Batches> showAllBatch() {
		return repo.findAll();
	}
	
	@DeleteMapping("/delete-batch/{}")
	public void deleteProduct(@PathVariable int bId) {
		repo.deleteById(bId);
	}
	
	@PutMapping("/update-batch/{batchid}")
	public Batches updateBatch(@PathVariable int id, @RequestBody Batches newbatch) {

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
