package com.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.entity.Franchies;

@Repository
public interface FranchiesRepo extends JpaRepository<Franchies, Integer> {

	List<Franchies> findByEmailIdAndFranchiesContactInfo(String userNm, long pwd);
	
	
	

}
