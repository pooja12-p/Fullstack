package com.example.serverside.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.serverside.model.PujaCourseStudent;

public interface CourseStudentRepository extends JpaRepository<PujaCourseStudent, Long>{
	
	List<PujaCourseStudent> findByCourseInstructorId(Long instructorId);
	List<PujaCourseStudent> findByStudentId(Long studentId);

}
