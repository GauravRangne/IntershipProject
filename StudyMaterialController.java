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

import com.boot.dao.StudyMaterialRepo;

import com.boot.entity.StudyMaterial;

@RestController
public class StudyMaterialController {
	
	@Autowired
	StudyMaterialRepo  repo;
		
	@PostMapping("/add-study-material")
	public void savedata(@RequestBody StudyMaterial studymaterial) {
		repo.save(studymaterial);
		
	}
	
	@GetMapping("/show-study-material")
	public List<StudyMaterial> showAllData(){
		return repo.findAll();
	}
	
	
	@DeleteMapping("/delete-study-material/{id}")	
	public void deletedata(@PathVariable(name="id")int id) {
		repo.deleteById(id);
	}	
	
	@PutMapping("/update-study-material/{id}")
	public StudyMaterial updateStudyMaterial(@PathVariable int id, @RequestBody StudyMaterial newstudymaterial) {

		return repo.findById(id).map( 
			studymaterial->{
		
				studymaterial.setStudyMaterialDetails(newstudymaterial.getStudyMaterialDetails());
				studymaterial.setPassword(newstudymaterial.getPassword());
				studymaterial.setStudyMaterialName(newstudymaterial.getStudyMaterialName());
				studymaterial.setSubmitDate(newstudymaterial.getSubmitDate());
				return repo.save(studymaterial);
			}
			).orElseGet(
				()->repo.save(newstudymaterial)
			);				
		}
	
	   @GetMapping("/study-material-validation/{userNm}/{pwd}")
	      public List<StudyMaterial> validation(@PathVariable String userNm, @PathVariable String pwd){
		  System.out.println(userNm);
		System.out.println(pwd);
		return repo.findByStudyMaterialNameAndPassword(userNm, pwd);
	}

}