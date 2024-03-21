package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.dao.AdminReop;
import com.boot.dao.CourseRepo;
import com.boot.entity.Admin;
import com.boot.entity.Courses;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin("http://localhost:4200")
@RequestMapping("/courses")
@RestController
public class CoursesController {

	@Autowired
	CourseRepo repo;
	
	@Autowired
	AdminReop admRepo;
	
	@PostMapping("/add-courses/{adminId}")
	public void  savedata(@RequestBody Courses courses, @PathVariable String adminId) {
		
		repo.save(courses);
		Admin adm = admRepo.findById(adminId).get();
		courses.setAdminId(adm);
		
		repo.save(courses);
	}
	
	@GetMapping("/show-courses")
	public List<Courses> showAllDetails(){
		return repo.findAll();
	}
	
	@DeleteMapping("/delete-courses/{id}")
	public void deletedata(@PathVariable int id){
		repo.deleteById(id);
	}
	
	@PutMapping("/update-courses/{id}")
	public  Courses updateCourses(@PathVariable int id, @RequestBody Courses newcourses) {

		return repo.findById(id).map( 
			courses ->{
				courses.setCourseName(newcourses.getCourseName());
				courses.setCourseDescription(newcourses.getCourseDescription());
				courses.setCourseDuration(newcourses.getCourseDuration());
				courses.setPrice(newcourses.getPrice());
	
				return repo.save(courses);
			}
		).orElseGet(
				()->repo.save(newcourses)			
		);				
	}	
}
