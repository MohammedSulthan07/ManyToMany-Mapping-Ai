package com.mapping.hibernate.repository;

import com.mapping.hibernate.entity.Student;
import com.mapping.hibernate.entity.Course;

import java.util.List;


public interface StudentRepository {

    void saveStudent(Student student);

    Student findStudent(int studentId);


    Student findStudentWithCourse(int studentId);

    void updateCourseDetails(int studentId, int courseId, String courseName);

    void deleteStudent(int studentId);


    void addCourse(int studentId, Course course);

    void deleteCourse(int studentId, int courseId);

    void addCoStudent(int courseId, Student student);

    List<Student> findAllStudent();
}