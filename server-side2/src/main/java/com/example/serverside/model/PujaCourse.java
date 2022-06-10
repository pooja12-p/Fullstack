package com.example.serverside.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="puja_course")
public class PujaCourse implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="name")
	private String name;
	
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name="instructor_id", referencedColumnName = "id")
		private PujaUser instructor;

		public PujaCourse() {
			super();
			// TODO Auto-generated constructor stub
		}

		public PujaCourse(Long id, String name, PujaUser instructor) {
			super();
			Id = id;
			this.name = name;
			this.instructor = instructor;
		}

		public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			Id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public PujaUser getInstructor() {
			return instructor;
		}

		public void setInstructor(PujaUser instructor) {
			this.instructor = instructor;
		}

		
	}
