package com.jspiders.springREST.controller;

import java.util.List;

import javax.print.DocFlavor.READER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springREST.pojo.StudentPojo;
import com.jspiders.springREST.resopnse.StudentResponse;
import com.jspiders.springREST.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
		
	@PostMapping(path = "/add",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> addStudent(@RequestBody StudentPojo pojo) {
		StudentPojo student=service.addStudent(pojo);
		if(student != null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Data added successfully..!",student,null),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("Data not added successfully..!",null,null),HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping(path ="/search/{id}",
			     produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> searchStudent(@PathVariable int id){
	    StudentPojo student=service.searchStudent(id);
	   //success
	    if (student != null) {
			
	    	return new ResponseEntity<StudentResponse>(new StudentResponse("data found successfully..!",student,null),HttpStatus.FOUND);
		}// failure
	    return new ResponseEntity<StudentResponse>(new StudentResponse("Data not found..",null,null),HttpStatus.NOT_FOUND);
		
}
	
	@GetMapping(path = "/searchAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> searchAllStudent(){
		 
		List<StudentPojo> students=service.searchAllStudents();
		if (students.isEmpty()==false) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("data found Successfully..!",null,students),HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("data not found ..!",null,null),HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping(path = "/remove/{id}",
			      produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> removeStudent(@PathVariable int id){
		StudentPojo student=service.removeStudent(id);
		if (student != null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("data removed successfully..!",student,null),HttpStatus.OK);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("data not removed",null,null),HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping(path = "/update",
			       consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> updateStudent(@RequestBody StudentPojo pojo){
		StudentPojo student=service.updateStudent(pojo);
		if (student != null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("data updated successfully..!",student,null),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("data not updated",null,null),HttpStatus.NOT_ACCEPTABLE);
	}
	
	
	
}
