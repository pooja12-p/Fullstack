package com.example.serverside.model;
import java.io.Serializable;
import java.util.stream.Stream;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="puja_user")
public class PujaUser implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name="role")
	private PujaRole role;
	
	@Transient
	private String token;

	public PujaUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PujaUser(Long id, String name, String username, String password, PujaRole role) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PujaRole getRole() {
		return role;
	}

	public void setRole(PujaRole role) {
		this.role = role;
	}

	public PujaUser orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
//	public Stream<PujaCourseStudent> getStudent() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
