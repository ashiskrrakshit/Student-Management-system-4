package com.project.SMS.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.SMS.entity.EnrolledCourse;
import com.project.SMS.repo.EnrollmentRepo;

@Service
public class EnrollmentService {
	@Autowired
	private EnrollmentRepo enrollmentRepo;

	public EnrolledCourse createEnrollment(EnrolledCourse enroll) {
	EnrolledCourse newEnroll = enrollmentRepo.save(enroll);
		return newEnroll;
	}
	
    public EnrolledCourse getEnrollmentById(int enrollmentId) {
        return enrollmentRepo.findById(enrollmentId)
                .orElse(null);
    }
    public boolean deleteEnrollmentById(int enrollmentId) {
        Optional<EnrolledCourse> enrollmentOptional = enrollmentRepo.findById(enrollmentId);
        if (enrollmentOptional.isPresent()) {
        	enrollmentRepo.deleteById(enrollmentId);
            return true; // Enrollment deleted successfully
        } else {
            return false; // Enrollment not found or unable to delete
        }

}
}
