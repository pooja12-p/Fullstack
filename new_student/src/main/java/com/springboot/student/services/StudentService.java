package com.springboot.student.services;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.student.entity.Student;
import com.springboot.student.repository.StudentRepository;

@Component
@Transactional
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	public Student save(Student student) {
		return studentRepository.save(student);
	}

	public Optional<Student> findById(Long id) {
		return studentRepository.findById(id);
	}

	public Student getById(Long id) {
		return studentRepository.getById(id);
	}

	public void deleteStudentById(Long id) {
		 studentRepository.deleteById(id);
	}
	
	public void delete(Student st) {
		// TODO Auto-generated method stub
		studentRepository.delete(st);
	}
	
	public Student updateStudent(Student student) {
		Student existingStudent=studentRepository.findById(student.getId()).orElse(null);
		existingStudent.setName(student.getName());	
		existingStudent.setBirth_date(student.getBirth_date());
		existingStudent.setCity(student.getCity());
		existingStudent.setIncome(student.getIncome());
		existingStudent.setEducation(student.getEducation());
		existingStudent.setScholorship(student.isScholorship());
		return studentRepository.save(existingStudent);	
}
}