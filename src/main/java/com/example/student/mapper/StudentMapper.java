package com.example.student.mapper;

import java.util.UUID;

import com.example.student.dto.ImmutableStudentDto;
import com.example.student.dto.StudentDto;
import com.example.student.entity.Student;

public interface StudentMapper {

	public static StudentDto entityTStudentDto(Student student) {
	return ImmutableStudentDto.builder()
			.sTUDENT_No(UUID.fromString(student.getSTUDENT_NO()))
			.sTUDENT_NAME(student.getSTUDENT_NAME())
			.sTUDENT_DOJ(student.getSTUDENT_DOJ().toString())
			.sTUDENT_DOB(student.getSTUDENT_DOB().toString())
			.build();
	}
	
}
