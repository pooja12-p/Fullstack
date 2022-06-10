package com.example.serverside.model;

import java.util.stream.Stream;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="puja_course_student")
public class PujaCourseStudent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="student_id",referencedColumnName = "id")
	private PujaUser student;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="course_id",referencedColumnName= "id")
	private PujaCourse course;
	
	

	public PujaCourseStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public PujaCourseStudent(Long id, PujaUser student, PujaCourse course) {
		super();
		Id = id;
		this.student = student;
		this.course = course;
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public PujaUser getStudent() {
		return student;
	}


	public void setStudent(PujaUser student) {
		this.student = student;
	}


	public PujaCourse getCourse() {
		return course;
	}


	public void setCourse(PujaCourse course) {
		this.course = course;
	}

	
//	public Object getCourse() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public Stream<PujaCourseStudent> getStudent() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
