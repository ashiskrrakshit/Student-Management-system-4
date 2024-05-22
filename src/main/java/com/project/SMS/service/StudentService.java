package com.project.SMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.SMS.entity.Student;
import com.project.SMS.repo.StudentRepo;
@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	//create student
	public Student createUser(Student student) {
		Student newStudent = studentRepo.save(student);
		return newStudent;
	}

	//find all student
	@JsonIgnore
	public List<Student> findAllStudent() {
		List<Student> allStudent = studentRepo.findAll();
		return allStudent;
	}

	//get student by id
//	public Student getStuedentById(Integer studentId) {
//		Student getStudentById = studentRepo.findById(studentId);
//		return getStudentById;
//	}
	
	public Student getStudentById(Integer studentId) {
        return studentRepo.findById(studentId).orElse(null);
    }

	//delete student
		public String deleteStudent(Integer studentId) {
	        if (studentRepo.existsById(studentId)) {
	            studentRepo.deleteById(studentId);
	            return "Student with ID " + studentId + " deleted successfully.";
	        } else {
	            return "Student with ID " + studentId + " not found.";
	        }
	    }
	}









//package com.project.SMS.service;
//
//import com.project.SMS.entity.Enrollment;
//import com.project.SMS.entity.Student;
//import com.project.SMS.repo.StudentRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//@Service
//public class StudentService {
//
//    @Autowired
//    private StudentRepo studentRepo;
//
//    public Student createUser(Student student) {
//        List<Enrollment> enrollments = student.getEnrollments();
//        if (enrollments != null && !enrollments.isEmpty()) {
//            Enrollment enrollment = enrollments.get(0); // Assuming only one enrollment is provided
//            enrollment.setStudent(student); // Set the student for the enrollment
//            student.setEnrollments(Collections.singletonList(enrollment)); // Set the enrollment for the student
//        }
//        return studentRepo.save(student);
//    }
//
//    public List<Student> findAllStudent() {
//        return studentRepo.findAll();
//    }
//
//    public Student getStudentById(Integer studentId) {
//        return studentRepo.findById(studentId).orElse(null);
//    }
//
//    public String deleteStudent(Integer studentId) {
//        if (studentRepo.existsById(studentId)) {
//            studentRepo.deleteById(studentId);
//            return "Student with ID " + studentId + " deleted successfully.";
//        } else {
//            return "Student with ID " + studentId + " not found.";
//        }
//    }
//}
//
//
//
