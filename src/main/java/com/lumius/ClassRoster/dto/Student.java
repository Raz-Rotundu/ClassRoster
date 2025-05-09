package com.lumius.ClassRoster.dto;

/**
 * DTO class containing information about a student + getters and setters
 */
public class Student {
	private String firstName;
	private String lastName;
	final String studentID;
	private String cohort; // Language + cohort month/year
	
	public Student(String studentID) {
		this.studentID = studentID;
	}
	
	
	// Getters and Setters
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getStudentID() {
		return this.studentID;
		
	}
	
	public String getCohort() {
		return cohort;
	}
	
	public void setCohort(String cohort) {
		this.cohort = cohort;
	}
}
