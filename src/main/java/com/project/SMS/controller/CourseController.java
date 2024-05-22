package com.project.SMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.project.SMS.entity.Course;
import com.project.SMS.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
//	@PostMapping("/create")
//	private ResponseEntity<Course> createCourse(@RequestBody Course course) {
//		Course newCourse = courseService.createCourse(course);
//		return new ResponseEntity<>(newCourse, HttpStatus.OK);
//	}
	
	
}
