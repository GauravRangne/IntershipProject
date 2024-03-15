package com.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.entity.Admin;

@Repository
public interface AdminReop extends JpaRepository<Admin, String>{

	List<Admin> findByEmailIdAndPhoneNo(String email, long pwd);

}
