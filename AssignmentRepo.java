package com.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.entity.Assignment;

@Repository
public interface AssignmentRepo extends JpaRepository<Assignment,Integer> {

}
