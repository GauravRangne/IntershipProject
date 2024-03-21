package com.boot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.boot.dao.CourseRepo;
import com.boot.dao.TeachersRepo;
import com.boot.entity.Courses;
import com.boot.entity.Teacher;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/teacher")
@RestController
public class TeacherController{
	
	@Autowired
	TeachersRepo repo;
	
	@Autowired
	CourseRepo coursRepo;
	
	@PostMapping("/add-teacher/{courseName}")
	public void savedata(@RequestBody Teacher teacher, @PathVariable String courseName) {
		
		repo.save(teacher);
		
		List<Teacher> obj1 = repo.findByTeacherNm(teacher.getTeacherNm());
		
		List<String> courseNm = new ArrayList<String>();
		courseNm.add(courseName);
		
		Set<Courses> obj2 = coursRepo.findByCourseNameIn(courseNm);
		
		teacher.setCourse(obj2);
		
		repo.save(teacher);		
	}
//	localhost:8080/addteachers/Full%20Stack%20Java
	
	@DeleteMapping("delete-teacher/{id}")
    public void delById(@PathVariable String id) {
    repo.deleteById(id);
	}
	
	@GetMapping("/show-teacher)")
	public List<Teacher> showAllData(){
		return repo.findAll();
		
	}

	@PutMapping("/update-teacher/{id}")
	public Teacher updateTeacher(@PathVariable String id, @RequestBody Teacher newTeacher ) {

		return repo.findById(id).map( 
			teacher ->{
				teacher.setTeacherNm(newTeacher.getTeacherNm());
				teacher.setSubject(newTeacher.getSubject());
				teacher.setJoiningDate(newTeacher.getJoiningDate());
				teacher.setSalary(newTeacher.getSalary());
				return repo.save(teacher);
			}
			).orElseGet(
				()->repo.save(newTeacher)			
		);	
	}
	
	@PutMapping("/update-teacher-password/{id}")
	public Teacher updateTeacherPassword(@PathVariable String  id, @RequestBody Teacher newteacher) {
		return repo.findById(id).map( 
				teacher ->{			
					teacher.setPhoneNo(newteacher.getPhoneNo());
					return repo.save(teacher);
				}	
		).orElseGet(
				()->repo.save(newteacher)
		);				
	}	
	
}