package com.lumius.ClassRoster.dao;

import java.util.List;

import com.lumius.ClassRoster.dto.Student;

public interface ClassRosterDao {
	
	/**
	 * Adds given student to roster and associates it with the given student ID.
	 * @param studentID the ID to be associated with the given student
	 * @param student the student to be added
	 * @return returns nil if student was successfully added, 
	 * or student object if there already exists a student object associated with that ID in the roster
	 */
	Student addStudent(String studentID, Student student);
	
	/**
	 * Returns a List of all students currently in the roster
	 * @return list of all students currently in the roster
	 */
	List<Student> getAllStudents();
	
	/**
	 * Returns individual student associated with the given ID. Returns null if student does not exist in roster.
	 * @param studentID the ID of the student
	 * @return the Student from the roster whose ID matches the given, or null if no matches.
	 */
	Student getStudent(String studentID);
	
	/**
	 * Removes selected student from the roster, returning it.
	 * @param studentID the ID of the student to remove
	 * @return The removed Student, or nil if the student does not exist.
	 */
	Student removeStudent(String studentID);
	
	
}
