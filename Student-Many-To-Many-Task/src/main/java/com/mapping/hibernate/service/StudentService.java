package com.mapping.hibernate.service;

import com.mapping.hibernate.dto.CourseDTO;
import com.mapping.hibernate.dto.StudentDTO;
import com.mapping.hibernate.exception.CourseNotFoundException;
import com.mapping.hibernate.exception.StudentNotFoundException;

import java.util.List;

public interface StudentService {
    void saveStudent(StudentDTO studentDTO);

    StudentDTO findStudent(int studentId) throws StudentNotFoundException;

    StudentDTO findStudentWithCourse(int studentId) throws StudentNotFoundException;

    void updateCourserDetails(int studentId, int courseId, String courseName) throws StudentNotFoundException;

    void deleteStudent(int studentId) throws StudentNotFoundException;

    void addCourse(int studentId, CourseDTO courseDTO) throws StudentNotFoundException;

    void deleteCourse(int studentId, int courseId) throws StudentNotFoundException, CourseNotFoundException;

    void addCoStudent(int courseId, StudentDTO studentDTO) throws CourseNotFoundException;

    List<StudentDTO> findAllStudents();
}
