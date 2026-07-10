package com.mapping.hibernate.repository.impl;

import com.mapping.hibernate.config.DatabaseConfig;
import com.mapping.hibernate.entity.Course;
import com.mapping.hibernate.entity.Student;
import com.mapping.hibernate.repository.StudentRepository;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class StudentRepositoryImpl implements StudentRepository {


    private static final SessionFactory SESSION_FACTORY =
            DatabaseConfig.getSessionFactory();


    @Override
    public void saveStudent(Student student) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(student);
            tx.commit();
        }
    }

    @Override
    public Student findStudent(int studentId) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Student student = session.find(Student.class, studentId);
            Hibernate.initialize(student.getCourseList());
            return student;
        }
    }

    @Override
    public Student findStudentWithCourse(int studentId) {
        try(Session session=SESSION_FACTORY.openSession()){
            Student student=session.find(Student.class,studentId);
            Hibernate.initialize(student.getCourseList());
            return student;
        }
    }

    @Override
    public void updateCourseDetails(int studentId, int courseId, String courseName) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx= session.beginTransaction();
            Student student=session.find(Student.class,studentId);
            student.getCourseList().stream().filter(course -> course.getId()==courseId).findFirst().ifPresent(pet -> pet.setCourseName(courseName));
            session.merge(student);
            Hibernate.initialize(student.getCourseList());
            tx.commit();
        }
    }

    @Override
    public void deleteStudent(int studentId) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx= session.beginTransaction();
            Student student=session.find(Student.class,studentId);
            session.remove(student);
            tx.commit();
        }
    }

    @Override
    public void addCourse(int studentId, Course course) {
        try(Session session=SESSION_FACTORY.openSession()) {
            Transaction tx = session.beginTransaction();
            Student student=session.find(Student.class,studentId);
            Hibernate.initialize(student.getCourseList().add(course));
            session.persist(course);
            tx.commit();
        }
    }

    @Override
    public void deleteCourse(int studentId, int courseId) {
        try(Session session=SESSION_FACTORY.openSession()) {
            Transaction tx = session.beginTransaction();
            Student student=session.find(Student.class,studentId);
            student.getCourseList().removeIf(course -> course.getId() == courseId);
            session.merge(student);
            tx.commit();
        }
    }

    @Override
    public void addCoStudent(int courseId, Student student) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction transaction = session.beginTransaction();
            Course course = session.find(Course.class, courseId);
            if (Objects.nonNull(student)) {
                course.getStudentList().add(student);
                session.merge(course);
            }
            transaction.commit();
        }
    }

    @Override
    public List<Student> findAllStudent() {
        String hql = "SELECT o FROM Owner o";
        try (Session session = SESSION_FACTORY.openSession()) {
            return session.createSelectionQuery(hql, Student.class)
                    .getResultList();
        }
    }
}
