package com.mapping.hibernate.repository;

import com.mapping.hibernate.entity.Course;

public interface CourseRepository {


    Course findCourse(int courseId);

    Course findWithCourse(int courseId);
}