package com.example.serverside.service;

import java.util.List;

import com.example.serverside.model.PujaCourse;

public interface CourseService {

	PujaCourse addCourse(PujaCourse course);

	PujaCourse updateCourse(PujaCourse course);

	void deleteCourse(Long courseId);

	List<PujaCourse> findAllCourse();

}
