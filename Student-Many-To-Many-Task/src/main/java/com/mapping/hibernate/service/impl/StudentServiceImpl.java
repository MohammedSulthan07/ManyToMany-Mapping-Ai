package com.mapping.hibernate.service.impl;

import com.mapping.hibernate.dto.CourseDTO;
import com.mapping.hibernate.dto.StudentDTO;
import com.mapping.hibernate.entity.Course;
import com.mapping.hibernate.entity.Student;
import com.mapping.hibernate.exception.CourseNotFoundException;
import com.mapping.hibernate.exception.StudentNotFoundException;
import com.mapping.hibernate.repository.CourseRepository;
import com.mapping.hibernate.repository.StudentRepository;
import com.mapping.hibernate.repository.impl.CourseRepositoryImpl;
import com.mapping.hibernate.repository.impl.StudentRepositoryImpl;
import com.mapping.hibernate.service.StudentService;
import com.mapping.hibernate.util.MapperUtil;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class StudentServiceImpl implements StudentService {

    private static StudentRepository studentRepository;
    private static CourseRepository courseRepository;

    public StudentServiceImpl() {
        studentRepository = new StudentRepositoryImpl();
        courseRepository = new CourseRepositoryImpl();
    }

    @Override
    public void saveStudent(StudentDTO studentDTO) {
        Student student = MapperUtil.convertStudentDtoToEntity(studentDTO);
        studentRepository.saveStudent(student);
    }

    @Override
    public StudentDTO findStudent(int studentId) throws StudentNotFoundException {
        Student student = studentRepository.findStudent(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student not found with id : " + studentId);
        }
        return MapperUtil.convertStudentEntityToDtoWithoutCourse(student);
    }

    @Override
    public StudentDTO findStudentWithCourse(int studentId) throws StudentNotFoundException {
        Student student = studentRepository.findStudentWithCourse(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student not found with id : " + studentId);
        }
        return MapperUtil.convertStudentEntityToDto(student);
    }

    @Override
    public void updateCourserDetails(int studentId, int courseId, String courseName) throws StudentNotFoundException {
        Student student = studentRepository.findStudent(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student not found");
        }
        studentRepository.updateCourseDetails(studentId,courseId, courseName);
    }

    @Override
    public void deleteStudent(int studentId) throws StudentNotFoundException {
        Student student = studentRepository.findStudent(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student not found");
        }
        studentRepository.deleteStudent(studentId);
    }

    @Override
    public void addCourse(int studentId, CourseDTO courseDTO) throws StudentNotFoundException {
        Student student = studentRepository.findStudent(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student not found");
        }
        Course course = MapperUtil.convertCourseDtoToEntity(courseDTO);
        student.getCourseList().add(course);
        course.getStudentList().add(student);
        studentRepository.addCourse(studentId, course);
    }

    @Override
    public void deleteCourse(int studentId, int courseId) throws StudentNotFoundException, CourseNotFoundException {
        Student student = studentRepository.findStudent(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student not found");
        }else if (Objects.isNull(student.getCourseList().stream().filter(course ->courseId==course.getId() ).findFirst().isEmpty())) {
            throw  new CourseNotFoundException("");
        }else {
            studentRepository.deleteCourse(studentId,courseId);
        }
    }

    @Override
    public void addCoStudent(int courseId, StudentDTO studentDTO) throws CourseNotFoundException {
        Course course = courseRepository.findCourse(courseId);
        if (Objects.isNull(course)) {
            throw new CourseNotFoundException("Course not found");
        } else {
            Student student = MapperUtil.convertStudentDtoToEntityWithoutCourse(studentDTO);
            studentRepository.addCoStudent(courseId, student);
        }
    }

    @Override
    public List<StudentDTO> findAllStudents() {
        return studentRepository.findAllStudent().stream().map(MapperUtil::convertStudentEntityToDto).toList();
    }
}
