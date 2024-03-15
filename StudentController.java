package com.boot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import com.boot.dao.CourseRepo;
import com.boot.dao.StudentRepo;
import com.boot.dao.TeachersRepo;
import com.boot.entity.Batches;
import com.boot.entity.Courses;
import com.boot.entity.Student;
import com.boot.entity.Teacher;

@RequestMapping("/student")
@RestController
public class StudentController {
	
	@Autowired
	StudentRepo  repo;

	@Autowired
	TeachersRepo teacherRepo;
	
	@Autowired
	BatchesRepo batchRepo;
	
	@Autowired
	CourseRepo coursRepo;

	@PostMapping("/add-student/{teacherId}")
	public void savedata(@RequestBody Student student,  @PathVariable String teacherId) {
		repo.save(student);
		
	    Teacher teach = teacherRepo.findById(teacherId).get();
		student.setTeacherId(teach);
		
		repo.save(student);		
	}
	
	@PostMapping("/add-batch-to-student/{batchId}")
	public void savedata2(@RequestBody Student student,  @PathVariable int batchId) {
		
		repo.save(student);
		
		Batches batch = batchRepo.findById(batchId).get();
		student.setBatchId(batch);
		
		repo.save(student);		
	}
	
	@PostMapping("/add-course-to-student/{courseName}")
	public void savedata3(@RequestBody Student student, @PathVariable String courseName) {
		
		repo.save(student);
		
		List<Student> obj1 = repo.findByFirstName(student.getFirstName());
		
		List<String> courseNm = new ArrayList<String>();
		courseNm.add(courseName);
		
		Set<Courses> obj2 = coursRepo.findByCourseNameIn(courseNm);
		
		student.setCourse(obj2);
		
		repo.save(student);		
	}
	
	@GetMapping("/show-student")
	public List<Student> showAllData(){
		return repo.findAll();
	}
	
	@DeleteMapping("/delete-student/{id}")
	public void deletedata(@PathVariable(name="id")String id) {
		repo.deleteById(id);
	}

	@PutMapping("/update-student/{id}")
	public Student updateStudent(@PathVariable String id, @RequestBody Student newstudent) {
	
			return repo.findById(id).map( 
				student ->{
					student.setFirstName(newstudent.getFirstName());
					student.setMiddleName(newstudent.getMiddleName());
					student.setLastName(newstudent.getLastName());
					student.setAddress(newstudent.getAddress());
					student.setStudentAge(newstudent.getStudentAge());
					student.setAdmissionDate(newstudent.getAdmissionDate());
					return repo.save(student);
				}
				).orElseGet(
					()->repo.save(newstudent)		
				);		
		}
	
	@PutMapping("/update-student-password/{id}")
	public Student updateStudentPassword(@PathVariable String  id, @RequestBody Student newstudent) {
		return repo.findById(id).map( 
			student ->{			
				student.setPhoneNo(newstudent.getPhoneNo());
				return repo.save(student);
			}	
		).orElseGet(
				()->repo.save(newstudent)
		);				
	}
	
	@GetMapping("/student-validation/{userNm}/{pwd}")
	public List<Student> validation(@PathVariable String userNm, @PathVariable long pwd){
		System.out.println(userNm);
		System.out.println(pwd);
		return repo.findByEmailIdAndPhoneNo(userNm, pwd);
	}

}
