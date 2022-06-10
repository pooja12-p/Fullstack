package com.springboot.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{


}