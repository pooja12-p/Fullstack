package com.example.serverside.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.serverside.model.PujaCourse;
import com.example.serverside.repository.CourseRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;
	private CrudRepository<PujaCourse, Long> courseRepositoy;
	
	@Override
	public PujaCourse addCourse(PujaCourse course) {
		return courseRepository.save(course);
		
	}
	
	@Override
	public PujaCourse updateCourse(PujaCourse course) {
		return courseRepository.save(course);
	}
	
	@Override
	public void deleteCourse(Long courseId) {
		courseRepositoy.deleteById(courseId);
	}
	
	@Override
	public List<PujaCourse> findAllCourse(){
		return courseRepository.findAll();
	}
}
