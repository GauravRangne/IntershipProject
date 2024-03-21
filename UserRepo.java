package com.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{

	List<User> findByEmailIdAndPhoneNo(String userNm, long pwd);
	
}
