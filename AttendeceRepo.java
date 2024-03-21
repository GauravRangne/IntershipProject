package com.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.entity.Attendance;

@Repository
public interface AttendeceRepo extends JpaRepository<Attendance, Integer> {

}