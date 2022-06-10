package com.example.serverside.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.serverside.model.PujaCourse;
import com.example.serverside.model.PujaCourseStudent;
import com.example.serverside.service.CourseStudentService;

@RestController
public class StudentController {
	
	@Autowired
	private CourseStudentService courseStudentService;
	
	@GetMapping("/api/student/courses/{studentId}")
	public ResponseEntity<?> findAllCousrsesOfStudent(@PathVariable Long studentId){
		List<PujaCourse> courseList = 
				courseStudentService.findAllCoursesOfStudent(studentId).stream().map(cs -> cs.getCourse()).collect(Collectors.toList());
				return new ResponseEntity<>(courseList, HttpStatus.OK);
	}
	
	@PostMapping("/api/student/enroll")
	public ResponseEntity<?> enroll(@RequestBody PujaCourseStudent courseStudent){
		return new ResponseEntity<>(courseStudentService.saveCourseStudent(courseStudent), HttpStatus.CREATED);
			
	}
}
