package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.boot.dao.CourseRepo;
import com.boot.entity.Courses;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class CoursesController {

	@Autowired
	CourseRepo repo;
	
	@PostMapping("/addCourses")
	public void  savedata(@RequestBody Courses courses) {
		 repo.save(courses);
	}
	
	@GetMapping("/showDetails")
	public List<Courses> showAllDetails(){
		return repo.findAll();
	}
	
	@DeleteMapping("/byId/{id}")
	public void deletedata(@PathVariable (name="id") int id){
		repo.deleteById(id);
	}
	
	@PutMapping("/updatebyId/{id}")
	public  Courses updateCourses(@PathVariable int id, @RequestBody Courses newcourses) {
		//TODO: process PUT request
		
 
			
			return repo.findById(id).map( 
					courses ->{
						courses.setCourseName(newcourses.getCourseName());
						courses.setCourseDescription(newcourses.getCourseDescription());
						courses.setCourseDuration(newcourses.getCourseDuration());
						
						
						return repo.save(courses);
					}
					
					
					).orElseGet(
							()->repo.save(newcourses)
							
							);
					
		}
//	assign batch ,create batch,finAll,finbyId,
	
}
