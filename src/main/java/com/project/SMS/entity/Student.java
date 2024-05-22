package com.project.SMS.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="firstname")
	private String sFirstName;
	
	@Column(name="lastname")
	private String sLastName;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(name="mobilenumber")
	private String mobileNumber;
	
	@Column(name = "address")
	private String address;
	

	@OneToMany(mappedBy = "student")  
	@JoinColumn(name = "Enrolled_Course", referencedColumnName = "id")
	private List<EnrolledCourse> enrolledCourse;
	
//	@ManyToMany
//	@JoinTable(name = "STUDENT_COURSE", 
//		joinColumns = @JoinColumn(name="STUDENT_ID",referencedColumnName = "id"), 
//		inverseJoinColumns = @JoinColumn(name = "COURSE_ID", referencedColumnName = "id"))
//	private List<Course> courses = new ArrayList<>();
//	

}
