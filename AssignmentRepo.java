package com.boot.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.entity.Assignment;

@Repository
public interface AssignmentRepo extends JpaRepository<Assignment,Integer> {

	public List<Assignment> findByStudentNm(String studName);

	public List<Assignment> findByAsignDate(Date asignDate);
	
}
