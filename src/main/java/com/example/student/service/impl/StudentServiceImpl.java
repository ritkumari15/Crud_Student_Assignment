package com.example.student.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.dto.StudentDto;
import com.example.student.entity.Student;
import com.example.student.mapper.StudentMapper;
import com.example.student.repo.StudentRepository;
import com.example.student.service.StudentService;
import com.example.student.util.DateConverter;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public StudentDto createStudent(StudentDto studentDto) {
		
		try {
			Student student = new Student();
			BeanUtils.copyProperties(student, studentDto);
			student.setSTUDENT_DOB(DateConverter.stringToDate(studentDto.getSTUDENT_DOB()));
			student.setSTUDENT_DOJ(DateConverter.stringToDate(studentDto.getSTUDENT_DOJ()));
			
			student.setSTUDENT_NO(UUID.randomUUID().toString());
			return StudentMapper.entityTStudentDto(studentRepository.save(student));
		}
		catch(Exception e) {
			System.out.println("encounter exception while create student in service"+e);
		}
		return null;
	}

	@Override
	public StudentDto getStudent(UUID STUDENT_NO) {
		try {
			Optional<Student> student = studentRepository.findById(STUDENT_NO.toString());
			if(student.isPresent()) {
				return StudentMapper.entityTStudentDto(student.get());
			}
		}
		catch(Exception e) {
			System.out.println("encounter exception while fetching student in service"+e);
		}
		return null;
	}

	@Override
	public StudentDto updateStudent(StudentDto studentDto) {
		try {
			Optional<Student> student = studentRepository.findById(studentDto.getSTUDENT_No().toString());
			if(student.isPresent()) {
				Student newStudent = new Student();
				BeanUtils.copyProperties(newStudent, studentDto);
				return StudentMapper.entityTStudentDto(studentRepository.save(newStudent));
			}
		}
		catch(Exception e) {
			System.out.println("encounter exception while updating student in service"+e);
		}
		return null;
	}

	@Override
	public StudentDto deleteStudent(UUID STUDENT_NO) {
		try {
			Optional<Student> student = studentRepository.findById(STUDENT_NO.toString());
			if(student.isPresent()) {
				studentRepository.delete(student.get());
				return StudentMapper.entityTStudentDto(student.get());
			}
		}
		catch(Exception e) {
			System.out.println("encounter exception while deleting student in service"+e);
		}
		return null;
		
	}

}
