package com.project.SMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.SMS.entity.Course;
import com.project.SMS.entity.Student;

import com.project.SMS.service.StudentService;


@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
		
	//get all student
    @GetMapping("/all")
    @JsonIgnore
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> allStudents = studentService.findAllStudent();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }
	


    // get student by Id
    @GetMapping("/studentId/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer studentId) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	    
    
//    @GetMapping("/{id}/courses")
//    public List<Course> getAllCoursesForStudent(@PathVariable int id) {
//        Student student = studentService.getStudentById(id);
//        return student.getCourses();
//    }
	
}
