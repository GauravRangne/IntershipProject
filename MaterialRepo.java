package com.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.entity.Material;

@Repository
public interface MaterialRepo extends JpaRepository<Material, Integer>{

	public List<Material> findByCategory(String cat);

}
