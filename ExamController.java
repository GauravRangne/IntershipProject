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

import com.example.demo.dao.ExamRepo;
import com.example.demo.entity.Exam;

@RestController
@CrossOrigin("http://localhost:4200")
public class ExamController {
	
	@Autowired
	private ExamRepo repo; 
	
	@PostMapping("/addexam")
	public void addexam(@RequestBody Exam exam) {
		repo.save(exam);
	}
	
	@GetMapping("/showallexam")
	public List<Exam> showAllExam() {
		return repo.findAll();
	}
	
	@DeleteMapping("/deleteexam/{}")
	public void deleteExam(@PathVariable int eId) {
		repo.deleteById(eId);
	}
	
	@PutMapping("/updatebyId/{examid}")
	public Exam updateExam(@PathVariable int id, @RequestBody Exam newexam) {
		//TODO: process PUT request
		
 
			
			return repo.findById(id).map( 
					exam ->{
						exam.setExamDate(newexam.getExamDate());
						exam.setDuration(newexam.getDuration());
						exam.setTotalMarks(newexam.getTotalMarks());
						exam.setPassingMarks(newexam.getPassingMarks());
						exam.setExamTopic(newexam.getExamTopic());
						
						return repo.save(exam);
					}
					
					
					).orElseGet(
							()->repo.save(newexam)
							
							);
					
		}

}

