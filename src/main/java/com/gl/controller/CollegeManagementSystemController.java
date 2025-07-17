package com.gl.controller;

import com.gl.dto.ResponseDTO;
import com.gl.dto.StudentDTO;
import com.gl.entity.Student;
import com.gl.exception.CollegeManagementSystemException;
import com.gl.service.CollegeManagementSystemService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeManagementSystemController {

    @Autowired
    private CollegeManagementSystemService collegeManagementSystemService;
    @PostMapping("/add-student")
    public ResponseEntity<ResponseDTO> addStudent(@RequestBody StudentDTO studentDTO) throws CollegeManagementSystemException{
            ResponseDTO responseDTO = collegeManagementSystemService.addStudent(studentDTO);

            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/get-students/{courseId}")
    public ResponseEntity<List<Student>> getStudent(@PathVariable Integer courseId) throws  CollegeManagementSystemException{

        List<Student> studentList = collegeManagementSystemService.getStudent(courseId);

        return new ResponseEntity<>(studentList, HttpStatus.OK);

    }

    @PutMapping("/updateStudent/{email}")
    public ResponseEntity<ResponseDTO> updateStudent(@PathVariable String email, @RequestBody StudentDTO studentDTO){
        ResponseDTO responseDTO = collegeManagementSystemService.updateStudent(email, studentDTO);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent/{email}")
    public ResponseEntity<ResponseDTO> deleteStudent(@PathVariable String email) throws CollegeManagementSystemException{
        ResponseDTO responseDTO = collegeManagementSystemService.deleteStudent(email);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
