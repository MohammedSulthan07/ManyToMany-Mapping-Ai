package com.mapping.hibernate.service.impl;

import com.mapping.hibernate.dto.CourseDTO;
import com.mapping.hibernate.entity.Course;
import com.mapping.hibernate.exception.CourseNotFoundException;
import com.mapping.hibernate.repository.CourseRepository;
import com.mapping.hibernate.repository.impl.CourseRepositoryImpl;
import com.mapping.hibernate.service.CourseService;
import com.mapping.hibernate.util.MapperUtil;

import java.util.Objects;

public class CourseServiceImpl implements CourseService {

    private static CourseRepository courseRepository;
    public CourseServiceImpl(){
        this.courseRepository =new CourseRepositoryImpl();
    }

    @Override
    public CourseDTO findCourse(int courseId) throws CourseNotFoundException {
        Course course=courseRepository.findCourse(courseId);
        if(Objects.isNull(course)){
            throw new CourseNotFoundException("Course not found");
        }

        return MapperUtil.convertCourseEntityToDto(course);
    }

    @Override
    public CourseDTO findCourseWithOwner(int courseId) throws CourseNotFoundException {
        Course course=courseRepository.findCourse(courseId);
        if(Objects.isNull(course)){
            throw new CourseNotFoundException("Course not found");
        }
        return MapperUtil.convertCourseEntityToDto(course);
    }
}
