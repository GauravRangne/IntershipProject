package com.boot.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.entity.Courses;

@Repository
public interface CourseRepo extends JpaRepository<Courses, Integer> {

	public Set<Courses> findByCourseNameIn(List<String> lstofCourses);

}
