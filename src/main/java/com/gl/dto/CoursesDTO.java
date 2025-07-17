package com.gl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoursesDTO {

    private Integer courseId;

    private String title;

    private InstructorDTO instructorDTO;
}
