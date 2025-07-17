package com.gl.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_id", nullable = false)
    private Instructor instructor;



}
