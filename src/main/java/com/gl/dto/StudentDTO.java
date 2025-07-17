package com.gl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class StudentDTO {

    private Integer studentId;

    private String name;

    private String email;

    private CoursesDTO coursesDTO;
}
