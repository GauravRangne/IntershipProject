package com.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.entity.Franchisee;

@Repository
public interface FranchiseeRepo extends JpaRepository<Franchisee, String> {

	List<Franchisee> findByEmailIdAndPhoneNo(String userNm, long pwd);
	
}
