package com.mapping.hibernate.repository.impl;

import com.mapping.hibernate.config.DatabaseConfig;
import com.mapping.hibernate.entity.Course;
import com.mapping.hibernate.repository.CourseRepository;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CourseRepositoryImpl implements CourseRepository {

    private static final SessionFactory SESSION_FACTORY =
            DatabaseConfig.getSessionFactory();


    @Override
    public Course findCourse(int courseId) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Course course=session.find(Course.class,courseId);
            Hibernate.initialize(course.getStudentList());
            return course;
        }
    }

    @Override
    public Course findWithCourse(int courseId) {
        try(Session session=SESSION_FACTORY.openSession()) {
            Course course = session.find(Course.class, courseId);
            Hibernate.initialize(course.getStudentList());
            return course;
        }
    }
}
