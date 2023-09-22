package com.jspiders.springREST.resopnse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspiders.springREST.pojo.StudentPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentResponse {

	private String msg;
    private StudentPojo student;
    private List<StudentPojo> students;
}
