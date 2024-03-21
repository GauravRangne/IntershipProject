package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.boot.dao.AdminReop;
import com.boot.dao.MaterialRepo;
import com.boot.entity.Admin;
import com.boot.entity.Assignment;
import com.boot.entity.Courses;
import com.boot.entity.Material;

public class MaterialController {

	@Autowired
	MaterialRepo repo;
	
	@Autowired
	AdminReop admRepo;
	
	@PostMapping("/add-material")
	public void  savedata(@RequestBody Material material) {	
		repo.save(material);
	}
	
	@GetMapping("/show-material")
	public List<Material> showAllDetails(){
		return repo.findAll();
	}
	
	@GetMapping("/find-by-category/{cat}")
	public List<Material> showByStudNm(@PathVariable String cat){
		return repo.findByCategory(cat);
	}
	
	@DeleteMapping("/delete-material/{id}")
	public void deletedata(@PathVariable int id){
		repo.deleteById(id);
	}
	
	@PutMapping("/update-material/{id}")
	public  Material updateCourses(@PathVariable int id, @RequestBody Material newmaterial) {

		return repo.findById(id).map( 
				material ->{
					material.setCategory(newmaterial.getCategory());
					material.setLevel(newmaterial.getLevel());
					material.setQuantity(newmaterial.getQuantity());	
				return repo.save(material);
			}
		).orElseGet(
				()->repo.save(newmaterial)			
		);				
	}
}
