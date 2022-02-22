package com.example.student.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.dto.StudentDto;
import com.example.student.entity.Student;
import com.example.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	private static final String ERROR_MESSAGE="Error while processing the request";
	
	@Autowired
	private StudentService service;
	
	@RequestMapping(method= RequestMethod.POST, path="/create")
    public ResponseEntity<?> createEmployee(@RequestBody StudentDto studentDto){
        try{

            StudentDto studentDto1 = service.createStudent(studentDto);
            if(studentDto1!=null)
                return ResponseEntity.ok(studentDto1);


        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERROR_MESSAGE);
        }
        return null;
    }
	 @RequestMapping(method= RequestMethod.GET, path="/get/{id}")
	    public ResponseEntity<?> getEmployee(@PathVariable UUID STUDENT_NO){
	        try{

	            StudentDto studentDto = service.getStudent(STUDENT_NO);
	            if(studentDto!=null)
	                return ResponseEntity.ok(studentDto);
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with this id was not found");


	        }catch (Exception exception){
	            exception.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERROR_MESSAGE);
	        }

	    }
	 
	 @RequestMapping(method= RequestMethod.PUT, path="/update")
	    public ResponseEntity<?> updateEmployee( @RequestBody StudentDto studentDto){
	        try{
	             StudentDto studentDto1 = service.updateStudent( studentDto);
	            if(studentDto1!=null)
	                return ResponseEntity.ok(studentDto1);
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Stdent with this id was not found");


	        }catch (Exception exception){
	            exception.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERROR_MESSAGE);
	        }

	    }
	    @RequestMapping(method= RequestMethod.DELETE, path="/delete/{id}")
	    public ResponseEntity<?> deleteEmployee(@PathVariable UUID STUDENT_NO){
	        try{

	        	 StudentDto studentDto = service.deleteStudent(STUDENT_NO);
		            if(studentDto!=null)
		                return ResponseEntity.ok(studentDto);
		            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with this id was not found");



	        }catch (Exception exception){
	            exception.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERROR_MESSAGE);
	        }

	    }


}
