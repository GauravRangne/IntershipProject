package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.boot.dao.UserRepo;
import com.boot.entity.User;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {

	@Autowired
	UserRepo repo;
	
	@GetMapping("/validation/{userNm}/{pwd}")
	public List<User> validation(@PathVariable String userNm , @PathVariable long pwd){
		return repo.findByEmailIdAndPhoneNo(userNm, pwd);
	}
	
	@GetMapping("/show-users")
	public List<User> showAllData(){
		return repo.findAll();
	}
	
	@DeleteMapping("/delete-user/{id}")
	public void deletedata(@PathVariable(name="id")String id) {
		repo.deleteById(id);
	}
}
