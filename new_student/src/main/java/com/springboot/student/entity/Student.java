package com.springboot.student.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name="new_student")
@Data
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
    private String name;
	
	@Column(name = "birth_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate birth_date;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "income")
	private Long income;
	
	@Column(name = "education")
	private String education;
	
	@Column(name = "scholorship")
	private boolean scholorship;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(Long id, String name, LocalDate birth_date, String city, Long income, String education,
			boolean scholorship) {
		this.id = id;
		this.name = name;
		this.birth_date = birth_date;
		this.city = city;
		this.income = income;
		this.education = education;
		this.scholorship = scholorship;
	}

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public Date getBirth_date() {
//		return birth_date;
//	}
//
//	public void setBirth_date(Date birth_date) {
//		this.birth_date = birth_date;
//	}
//
//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public Long getIncome() {
//		return income;
//	}
//
//	public void setIncome(Long income) {
//		this.income = income;
//	}
//
//	public String getEducation() {
//		return education;
//	}
//
//	public void setEducation(String education) {
//		this.education = education;
//	}
//
//	public boolean isScholorship() {
//		return scholorship;
//	}
//
//	public void setScholorship(boolean scholorship) {
//		this.scholorship = scholorship;
//	}
}

