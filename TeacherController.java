package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


import com.boot.dao.TeachersRepo;
import com.boot.entity.Teacher;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
public class TeacherController{
	
	@Autowired
	TeachersRepo repo;
	
	@PostMapping("/addTeacher")
	public void saveData(@RequestBody Teacher teacher) {
		repo.save(teacher);
	}
	@DeleteMapping("delById/{id}")
    public void delById(@PathVariable int id) {
    repo.deleteById(id);
	}
	
	@GetMapping("/showTeacher)")
	public List<Teacher> showAllData(){
		return repo.findAll();
		
	}
	
	
	
	
	@PutMapping("/updatebyId/{id}")
	public Teacher updateTeacher(@PathVariable int id, @RequestBody Teacher newTeacher ) {
		//TODO: process PUT request
		
 
			
			return repo.findById(id).map( 
					teacher ->{
						teacher.setTeacherNm(newTeacher.getTeacherNm());
						teacher.setTeacherEmail(newTeacher.getTeacherEmail());
						teacher.setMobileNo(newTeacher.getMobileNo());
						teacher.setSubject(newTeacher.getSubject());
						teacher.setJoiningDate(newTeacher.getJoiningDate());
						teacher.setSalary(newTeacher.getSalary());
						teacher.setFrenchie(newTeacher.getFrenchie());
						teacher.setBatchNo(newTeacher.getBatchNo());
						
						
						
						
						
						return repo.save(teacher);
					}
					
					
					).orElseGet(
							()->repo.save(newTeacher)
							
							);
					
		}

	@GetMapping("/validation/{userNm}/{pwd}")
	public List<Teacher> validation(@PathVariable String userNm, @PathVariable String pwd){
		System.out.println(userNm);
		System.out.println(pwd);
		return repo.findByTeacherNmAndPassword(userNm, pwd);
	}
	
}