package com.gl.dto;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDTO {

    private Integer instructorId;

    private String name;

    private String email;

    private DepartmentDTO departmentDTO;
}
