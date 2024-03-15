package com.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.entity.Batches;

@Repository
public interface BatchesRepo extends JpaRepository<Batches, Integer> {

}
