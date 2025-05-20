package com.lumius.ClassRoster.service;

import java.util.List;

import com.lumius.ClassRoster.dao.ClassRosterPersistenceException;
import com.lumius.ClassRoster.dto.Student;

/**
 * Service layer acting as API for roster persistance.
 * Enforces the following business rules
 * 1. IDs must be unique
 * 2. All fields of a student profile must have values
 */
public interface ClassRosterServiceLayer {
	
	/**
	 * Adds a new Student object to the roster
	 * @param student the Student object to be added
	 * @throws ClassRosterDuplicateIdException thrown if student's ID already exists
	 * @throws ClassRosterDataValidationException thrown is student has null values in fields
	 * @throws ClassRosterPersistenceException thrown on error reading and writing to file
	 */
	void createStudent(Student student) throws 
		ClassRosterDuplicateIdException,
		ClassRosterDataValidationException,
		ClassRosterPersistenceException;
	
	
	/**
	 * Returns a list of all students currently in the roster
	 * @return List of all students currently in the roster
	 * @throws ClassRosterPersistenceException on error reading from roster
	 */
	List<Student> getAllStudents() throws ClassRosterPersistenceException;
	
	
	/**
	 * Returns a specific student from the roster matching the given ID
	 * @param studentId the ID of the student to be found
	 * @return Student object matching the given ID
	 * @throws ClassRosterPersistenceException on error reading from roster
	 */
	Student getStudent(String studentId) throws ClassRosterPersistenceException;
	
	/**
	 * Removes student with given ID from the roster and returns it, updating roster persistence
	 * @param studentId the ID of the student to remove
	 * @return the Student which was removed
	 * @throws ClassRosterPersistenceException on reading and writing to roster file,
	 */
	Student removeStudent(String studentId) throws ClassRosterPersistenceException;
}
