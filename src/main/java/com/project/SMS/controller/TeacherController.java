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
import com.project.SMS.entity.Teacher;
import com.project.SMS.service.CourseService;
import com.project.SMS.service.StudentService;
import com.project.SMS.service.TeacherService;
@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;
	
	// create a student
	@PostMapping("/create")
	private ResponseEntity<Teacher> createStudent(@RequestBody Teacher teacher) {
		Teacher createdTeacher = teacherService.createUser(teacher);
		return ResponseEntity.ok(createdTeacher);
	}
	
	
	//get all student
    @GetMapping("/all")
    @JsonIgnore
    public ResponseEntity<List<Teacher>> getAllStudents() {
        List<Teacher> allTeachers = teacherService.findAllTeacher();
        return new ResponseEntity<>(allTeachers, HttpStatus.OK);
    }
	


    // get student by Id
    @GetMapping("/Id/{teacherId}")
    public ResponseEntity<Teacher> getStudentById(@PathVariable Integer teacherId) {
    	Teacher student = teacherService.getTeacherById(teacherId);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
	//deleteUser(
	@DeleteMapping("/delete/{teacherId}")
	public ResponseEntity<String> deleteTeacher(@PathVariable Integer teacherId) {
		String status = teacherService.deleteTeacher(teacherId);

		return new ResponseEntity<String>(status, HttpStatus.OK);
	}
	
	
	//add student
	@PostMapping("/create/student")
	private ResponseEntity<Student> createStudent(@RequestBody Student student) {
		Student createdStudent = studentService.createUser(student);
		return ResponseEntity.ok(createdStudent);
	}
	
//	//delete student(
	@DeleteMapping("/delete/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer studentId) {
		String status = studentService.deleteStudent(studentId);

		return new ResponseEntity<String>(status, HttpStatus.OK);
	}
	
	//create course
	@PostMapping("/create/course")
	private ResponseEntity<Course> createCourse(@RequestBody Course course) {
		Course newCourse = courseService.createCourse(course);
		return new ResponseEntity<>(newCourse, HttpStatus.OK);
	}
}
