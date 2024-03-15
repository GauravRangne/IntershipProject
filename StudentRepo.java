package com.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, String> {

	List<Student> findByEmailIdAndPhoneNo(String userNm, long pwd);

	public List<Student> findByFirstName(String firstName);
}