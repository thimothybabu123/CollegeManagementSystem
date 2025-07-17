package com.gl.repository;

import com.gl.entity.Courses;
import com.gl.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    public Student findByEmail(String email);

    public List<Student> findByCourses(Courses courses);
}
