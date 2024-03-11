package com.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.entity.HomeWork;

@Repository
public interface HomeWorkRepo extends JpaRepository<HomeWork,Integer> {

	
	

}
