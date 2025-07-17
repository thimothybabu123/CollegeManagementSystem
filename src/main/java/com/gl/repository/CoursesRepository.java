package com.gl.repository;

import com.gl.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoursesRepository extends JpaRepository<Courses, Integer> {



}
