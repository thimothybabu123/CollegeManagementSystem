package com.gl.service;


import com.gl.dto.CoursesDTO;
import com.gl.dto.ResponseDTO;
import com.gl.dto.StudentDTO;
import com.gl.entity.Courses;
import com.gl.entity.Student;
import com.gl.exception.CollegeManagementSystemException;
import com.gl.repository.CoursesRepository;
import com.gl.repository.DepartmentRepository;
import com.gl.repository.InstructorRepository;
import com.gl.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollegeManagementSystemServiceImpl implements CollegeManagementSystemService {

    @Autowired
    private CoursesRepository coursesRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public ResponseDTO addStudent(StudentDTO studentDTO) {

        Student student = studentRepository.findByEmail(studentDTO.getEmail());

        if(student!=null){
            throw new CollegeManagementSystemException("Student already Exists");
        }


        Courses course = coursesRepository.findById(studentDTO.getCoursesDTO().getCourseId())
                .orElseThrow(() ->
                        new CollegeManagementSystemException("Course not found with ID: " + studentDTO.getCoursesDTO().getCourseId()));


        Student student1 = new Student();
        student1.setName(studentDTO.getName());
        student1.setEmail(studentDTO.getEmail());

        student1.setCourses(course);

        studentRepository.save(student1);


        return new ResponseDTO("Student added successfully");
    }

    public List<Student> getStudent(Integer courseId){
        Courses courses = coursesRepository.findById(courseId)
                .orElseThrow(()->new CollegeManagementSystemException("Course not found"));
        if(courses == null){
            throw new CollegeManagementSystemException("Course not found");
        }
       List<Student> studentList =studentRepository.findByCourses(courses);
        return studentList;

    }

    public ResponseDTO updateStudent(String email, StudentDTO studentDTO){
        Student student = studentRepository.findByEmail(email);
        if(student == null){
            throw new CollegeManagementSystemException("Student does not exist");
        }
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        Courses courses = coursesRepository.findById(studentDTO.getCoursesDTO().getCourseId())
                .orElseThrow(()->new RuntimeException("Course not found"));

        student.setCourses(courses);

        studentRepository.save(student);

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("updated");
        return responseDTO;

    }

    public ResponseDTO deleteStudent(String email){
        Student student = studentRepository.findByEmail(email);
        if(student==null){
            throw new CollegeManagementSystemException("Student does not exist");
        }
        studentRepository.delete(student);

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Deleted");
        return responseDTO;
    }
}
