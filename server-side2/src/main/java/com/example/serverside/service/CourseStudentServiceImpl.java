package com.example.serverside.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.serverside.model.PujaCourseStudent;
import com.example.serverside.repository.CourseStudentRepository;

@Service
@Transactional
public class CourseStudentServiceImpl implements CourseStudentService{
	
	@Autowired
	private CourseStudentRepository courseStudentRepository;
	
	@Override
	public PujaCourseStudent saveCourseStudent(PujaCourseStudent courseStudent) {
		return courseStudentRepository.save((courseStudent));	
	}
	
	@Override
	public List<PujaCourseStudent> findAllCoursesOfStudent(Long studentId){
		return courseStudentRepository.findByStudentId(studentId);
	}
	
	@Override
	public List<PujaCourseStudent>findAllStudentsOfInstructor(Long instructorId){
		return courseStudentRepository.findByCourseInstructorId(instructorId);
	}
	
	@Override
	public List<PujaCourseStudent> findAllEnrolments(){
		return courseStudentRepository.findAll();
	}
}
