package com.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boot.entity.Admin;

@Repository
public interface AdminReop extends JpaRepository<Admin, String>{

//	@Query("select emailId from Admin")
//	String getEmailId();
}
