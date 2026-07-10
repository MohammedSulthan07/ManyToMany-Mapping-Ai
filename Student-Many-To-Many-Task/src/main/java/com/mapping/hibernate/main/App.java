package com.mapping.hibernate.main;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mapping.hibernate.dto.StudentDTO;
import com.mapping.hibernate.dto.CourseDTO;
import com.mapping.hibernate.service.StudentService;
import com.mapping.hibernate.service.impl.StudentServiceImpl;
import com.mapping.hibernate.service.CourseService;
import com.mapping.hibernate.service.impl.CourseServiceImpl;
import com.mapping.hibernate.util.InputUtil;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    public void run() {
        StudentService studentService = new StudentServiceImpl();
        CourseService courseService = new CourseServiceImpl();
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println("Welcome to Student Management");
                int menuOption = InputUtil.acceptMenuOption(scanner);
                switch (menuOption) {
                    case 1:
                        StudentDTO studentDTO = InputUtil.acceptStudentDetailsToSave(scanner);
                        CourseDTO courseDTO = InputUtil.acceptCourseDetailsToSave(scanner);
                        List<CourseDTO> cousreDTOList = new ArrayList<>();
                        cousreDTOList.add(courseDTO);
                        studentDTO.setCourseDTOList(cousreDTOList);
                        studentService.saveStudent(studentDTO);
                        System.out.println("Student has been saved successfully.");
                        break;
                    case 2:
                        int studentId = InputUtil.acceptStudentIdToOperate(scanner);
                        studentDTO = studentService.findStudent(studentId);
                        System.out.println("Student has been fetched successfully.");
                        System.out.println(studentDTO);
                        studentDTO = studentService.findStudentWithCourse(studentId);
                        System.out.println("Student with Courses has been fetched successfully.");
                        System.out.println(studentDTO);
                        break;
                    case 3:
                        studentId = InputUtil.acceptStudentIdToOperate(scanner);
                        int courseId = InputUtil.acceptCourseIdToOperate(scanner);
                        String courseName = InputUtil.acceptCourseDetailsToUpdate(scanner);
                        studentService.updateCourserDetails(studentId, courseId, courseName);
                        System.out.println("Course details of Student have been updated successfully.");
                        break;
                    case 4:
                        studentId = InputUtil.acceptStudentIdToOperate(scanner);
                        studentService.deleteStudent(studentId);
                        System.out.println("Student has been deleted successfully.");
                        break;
                    case 5:
                        courseId = InputUtil.acceptCourseIdToOperate(scanner);
                        courseDTO = courseService.findCourse(courseId);
                        System.out.println("Course has been fetched successfully.");
                        System.out.println(courseDTO);
                        courseDTO = courseService.findCourseWithOwner(courseId);
                        System.out.println("Course with owner has been fetched successfully.");
                        System.out.println(courseDTO);
                        break;
                    case 6:
                        studentId = InputUtil.acceptStudentIdToOperate(scanner);
                        courseDTO = InputUtil.acceptCourseDetailsToSave(scanner);
                        studentService.addCourse(studentId, courseDTO);
                        System.out.println("Course has been added successfully.");
                        break;
                    case 7:
                        studentId = InputUtil.acceptStudentIdToOperate(scanner);
                        courseId = InputUtil.acceptCourseIdToOperate(scanner);
                        studentService.deleteCourse(studentId, courseId);
                        System.out.println("Course has been deleted successfully.");
                        break;
                    case 8:
                        studentDTO = InputUtil.acceptStudentDetailsToSave(scanner);
                        courseId = InputUtil.acceptCourseIdToOperate(scanner);
                        studentService.addCoOwner(courseId, studentDTO);
                        System.out.println("Co-Student has been added successfully.");
                        break;
                    case 9:
                        List<StudentDTO>ownerDTOList=studentService.findAllStudents();
                        ownerDTOList.forEach(System.out::println);
                        System.out.println("Student has been fetched successfully");
                        break;
                    default:
                        System.out.println("Invalid option entered.");
                }
            } while (InputUtil.wantToContinue(scanner));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}