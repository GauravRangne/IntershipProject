package com.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.boot.entity.StudyMaterial;

@Repository
public interface StudyMaterialRepo extends JpaRepository<StudyMaterial, Integer> {

	List<StudyMaterial>findByStudyMaterialNameAndPassword(String userNm, String pwd);
}