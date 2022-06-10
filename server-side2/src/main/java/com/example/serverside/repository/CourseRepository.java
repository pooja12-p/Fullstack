package com.example.serverside.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.serverside.model.PujaCourse;

public interface CourseRepository extends JpaRepository<PujaCourse, Long>{


}
