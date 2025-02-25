package com.project.SMS.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.SMS.entity.EnrolledCourse;

@Repository
public interface EnrollmentRepo extends JpaRepository<EnrolledCourse, Integer> {

}
