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

import com.boot.dao.FeedbackRepo;
import com.boot.entity.Feedback;

@RestController
public class FeedbackController {

	@Autowired
	FeedbackRepo repo;
	
	@PostMapping("/add-feedback")
	public void savedata(@RequestBody Feedback feedback) {
		repo.save(feedback);
		
	}
	
	@GetMapping("/show-study-material")
	public List<Feedback> showAllData(){
		return repo.findAll();
	}
	
	
	@DeleteMapping("/delete-feedback/{id}")	
	public void deletedata(@PathVariable(name="id")int id) {
		repo.deleteById(id);
	}	
	
	@PutMapping("/update-feedback/{id}")
	public Feedback updateFeedback(@PathVariable int id, @RequestBody Feedback newFeedback) {

		return repo.findById(id).map( 
				feedback->{
					feedback.setRating(newFeedback.getRating());
					feedback.setReview(newFeedback.getReview());
					feedback.setTeacherNm(newFeedback.getTeacherNm());
				return repo.save(feedback);
			}
			).orElseGet(
				()->repo.save(newFeedback)
			);				
		}
}
