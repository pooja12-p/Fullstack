package com.springboot.student.restcontroller;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.student.entity.Student;
import com.springboot.student.exception.NoSuchElementFoundException;
import com.springboot.student.services.StudentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/task")

@Slf4j
public class StudentRestcontroller {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/message")
	public String DisplayMessage()
	{
		return "Hello Everyone";
	}
	
	@GetMapping("/student")
	public List<Student> FindAll()
	{
		return studentService.findAll();
	}
											
	@PostMapping("/student/add")
	public Student addEmployee(@RequestBody Student student)
	{
		LocalDate curDate = LocalDate.now();     
		   int age= Period.between(student.getBirth_date(), curDate).getYears();  
		    if(age<=5) {
		    	throw new RuntimeException("You must at least 5 years old");
		    }
		   return studentService.save(student);
	}
  
    @GetMapping("/student/{id}")
	public Optional<Student> getbyid(@PathVariable Long id)
	{
    	//custom exception handling
    	if(id == null) {
    		throw new RuntimeException("Student with this id not found !!");
    	}
    	return studentService.findById(id);
    	
	}
    
    @PutMapping("/student/update-student")
    public Student updatedetails(@RequestBody Student student)
    
    {
	 
//    	Student stud = studentService.getById(student.getId());
//    	stud.setId(student.getId());
//    	stud.setName(student.getName());
//    	stud.setBirth_date(student.getBirth_date());
//    	
//    	stud.setCity(student.getCity());
//    	stud.setIncome(student.getIncome());
//    	stud.setEducation(student.getEducation());
//    	stud.setScholorship(student.isScholorship());
    	LocalDate curDate = LocalDate.now();     
		   int age= Period.between(student.getBirth_date(), curDate).getYears();  
		    if(age<=5) {
		    	throw new RuntimeException("You must at least 5 years old");
		    }
		    return studentService.updateStudent(student); 	
    }
    
//    @PutMapping("/student/update-student")
//	public Student updateStudent(@RequestBody Student student) {
//    	LocalDate curDate = LocalDate.now();     
//		   int age= Period.between(student.getBirth_date(), curDate).getYears();  
//		    if(age<=5) {
//		    	throw new RuntimeException("You must at least 5 years old");
//		    }
// 	return studentService; 	
// }
//    
    @DeleteMapping("/student/delete-student/{id}")
    public String deleteEmployeebyid(@PathVariable Long id)

    {
    	//employeeRepository.deleteEmployeeById(id);
    	Student stud = studentService.getById(id);
    	studentService.delete(stud);
    	log.info("Record deleted of student whose Id was: "+id);
    	return "A record Deleted!";                                   
    }
      
    @ExceptionHandler()
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNoSuchElementFoundException(
          NoSuchElementFoundException exception){
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}

