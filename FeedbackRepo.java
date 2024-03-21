package com.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.Feedback;

public interface FeedbackRepo extends JpaRepository<Feedback, Integer>{

}
