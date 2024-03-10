package com.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.entity.Teacher;
@Repository
public interface TeachersRepo extends JpaRepository<Teacher ,Integer > {
	
	
	

	public List<Teacher> findByTeacherNmAndPassword(String userNm, String pwd);
	

}
