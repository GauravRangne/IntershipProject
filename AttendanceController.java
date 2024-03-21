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

import com.boot.dao.AttendeceRepo;
import com.boot.dao.StudentRepo;
import com.boot.dao.TeachersRepo;
import com.boot.entity.Attendance;
import com.boot.entity.Student;
import com.boot.entity.Teacher;

//@CrossOrigin("http://localhost:4200")
@RestController
public class AttendanceController {
	
	@Autowired
	AttendeceRepo repo;
	
	@Autowired
	TeachersRepo teacherRepo;
	
	@Autowired
	StudentRepo studentRepo;
	
	
	
	@PostMapping("/add-attendance/{teacherId}")
	public void savedata(@RequestBody Attendance attendance,  @PathVariable String teacherId) {
		repo.save(attendance);
		Teacher teach=teacherRepo.findById(teacherId).get();
		attendance.setTeacherId(teach);
		repo.save(attendance);
	}
	
	
	@PostMapping("/add-attendance/{studentId}")
	public void savedata2(@RequestBody Attendance attendance,  @PathVariable String studentId) {
		repo.save(attendance);
		Student teach=studentRepo.findById(studentId).get();
		attendance.setStudentId(teach);
		repo.save(attendance);
	}
	
	@GetMapping("/show-attendance")
	public List<Attendance> showAllData(){
		return repo.findAll();
	}
	
	@DeleteMapping("/delete-attendance/{id}")
	public void deletedata(@PathVariable(name="id")int id) {
		repo.deleteById(id);
	}

	
	@PutMapping("/update-attendance/{id}")
	public Attendance updatAttendance(@PathVariable int id, @RequestBody Attendance newattendace) {

			return repo.findById(id).map( 
				attendance ->{
	
					attendance.setDate(newattendace.getDate());
				
					attendance.setStatus(newattendace.getStatus());
	
					return repo.save(attendance);
				}
	
				).orElseGet(
					()->repo.save(updatAttendance(0, null))
				);		
		}

}

