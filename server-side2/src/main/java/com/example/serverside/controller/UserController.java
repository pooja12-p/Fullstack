package com.example.serverside.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.serverside.jwt.JwtTokenProvider;
import com.example.serverside.model.PujaCourseStudent;
import com.example.serverside.model.PujaRole;
import com.example.serverside.model.PujaUser;
import com.example.serverside.service.CourseService;
import com.example.serverside.service.CourseStudentService;
import com.example.serverside.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CourseService courseService;

	@Autowired
	private CourseStudentService courseStudentService;
	
	@PostMapping("/api/user/registeration")
	public ResponseEntity<?> register(@RequestBody PujaUser user){
		if(userService.findByUsername(user.getUsername())!= null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);	
		}
		user.setRole(PujaRole.STUDENT);
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
	}
	
	@GetMapping("/api/user/login")
	public ResponseEntity<?> getUser(Principal principal){
		if(principal == null) {
			return ResponseEntity.ok(principal);
		}
		UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) principal;
		PujaUser user = userService.findByUsername(authenticationToken.getName());
		user.setToken(tokenProvider.generateToken(authenticationToken));
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	@PostMapping("/api/user/enroll")
	public ResponseEntity<?> enrollCourse(@RequestBody PujaCourseStudent courseStudent){
		return new ResponseEntity<>(courseStudentService.saveCourseStudent(courseStudent), HttpStatus.CREATED);
	}
	
	@GetMapping("/api/user/courses")
	public ResponseEntity<?> getAllCourse(){
		return ResponseEntity.ok(courseService.findAllCourse());
	}
	
	@GetMapping("get/user/{id}")
	public ResponseEntity<?> getAllCourse(@PathVariable Long id){
		return ResponseEntity.ok(userService.getUser(id));
	}
	
	
}
	
