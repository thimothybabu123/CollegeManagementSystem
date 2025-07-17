package com.gl.service;

import com.gl.dto.ResponseDTO;
import com.gl.dto.StudentDTO;
import com.gl.entity.Student;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface CollegeManagementSystemService {

    public ResponseDTO addStudent(StudentDTO studentDTO);

    public List<Student> getStudent(Integer courseId);

    public ResponseDTO updateStudent(String email, StudentDTO studentDTO);

    public ResponseDTO deleteStudent(String email);
}
