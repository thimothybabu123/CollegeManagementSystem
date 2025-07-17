package com.gl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {

    private Integer departmentId;

    private String name;

    private List<InstructorDTO> instructorsDTOList;
}
