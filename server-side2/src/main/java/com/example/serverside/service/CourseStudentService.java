package com.example.serverside.service;

import java.util.List;

import com.example.serverside.model.PujaCourseStudent;

public interface CourseStudentService {

	PujaCourseStudent saveCourseStudent(PujaCourseStudent courseStudent);

	List<PujaCourseStudent> findAllCoursesOfStudent(Long studentId);

	List<PujaCourseStudent> findAllStudentsOfInstructor(Long instructorId);

	List<PujaCourseStudent> findAllEnrolments();

}
