package com.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.entity.Franchisee;

@Repository
public interface FranchiseeRepo extends JpaRepository<Franchisee, String> {

	String findFranchiesNameByEmailId(String franchEmail);

	long findPhoneNoByEmailId(String franchEmail);

//	public String 
	
}
