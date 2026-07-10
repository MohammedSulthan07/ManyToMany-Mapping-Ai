package com.mapping.hibernate.dto;

import com.mapping.hibernate.enums.CourseType;
import com.mapping.hibernate.enums.Grade;
import lombok.Data;

import java.time.LocalDate;


public class CourseDTO {
    private int id;
    private String courseName;
    private LocalDate enrollmentDate;
    private CourseType courseType;
    private Grade grade;
    private StudentDTO studentDTO;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                ", courseType=" + courseType +
                ", grade=" + grade +
                ", studentDTO=" + studentDTO +
                '}';
    }
}
