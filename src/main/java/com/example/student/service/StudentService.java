package com.example.student.service;

import java.util.UUID;

import javax.transaction.Transactional;

import com.example.student.dto.StudentDto;

public interface StudentService {
	
	@Transactional
	public StudentDto createStudent(StudentDto studentDto);
	
	@Transactional
	public StudentDto getStudent(UUID STUDENT_NO);
	
	@Transactional
	public StudentDto updateStudent(StudentDto studentDto);
	
	@Transactional
	public StudentDto deleteStudent(UUID STUDENT_NO);

}
