package com.mapping.hibernate.entity;


import com.mapping.hibernate.enums.CourseType;
import com.mapping.hibernate.enums.Grade;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "course_name",nullable = false)
    private String courseName;
    @Column(name = "enrollment_date",nullable = false)
    private LocalDate enrollmentDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "course_type")
    private CourseType courseType;
    @Enumerated(EnumType.STRING)
    private Grade grade;

    @ManyToMany(mappedBy = "courseList")
    private Set<Student > studentList = new HashSet<>();


}
