package com.project.SMS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.SMS.entity.Course;
import com.project.SMS.repo.CourseRepo;

@Service
public class CourseService {

	@Autowired
	private CourseRepo courseRepo;

	public Course createCourse(Course course) {
		// TODO Auto-generated method stub
		Course newCourse = courseRepo.save(course);
		return newCourse;
	}
}
