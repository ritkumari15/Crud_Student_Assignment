package com.example.student.dto;



import java.util.Date;
import java.util.UUID;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

import org.immutables.value.Value.Immutable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonDeserialize(as = ImmutableStudentDto.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Immutable
public interface StudentDto {
	
	@Nullable
	UUID getSTUDENT_No();
	
	@NotNull
	String getSTUDENT_NAME();
	
	@NotNull
	String getSTUDENT_DOB();
	
	@NotNull 
	String getSTUDENT_DOJ();
	

}
