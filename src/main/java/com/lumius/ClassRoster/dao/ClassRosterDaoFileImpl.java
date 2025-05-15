package com.lumius.ClassRoster.dao;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import com.lumius.ClassRoster.dto.Student;

/**
 * DAO implementation class for the ClassRoster.
 * Stores roster entries as a map, reads and writes roster to file
 */
public class ClassRosterDaoFileImpl implements ClassRosterDao{

	private final Map<String, Student> students = new HashMap<>();
	
	@Override
	public Student addStudent(String studentID, Student student) {
		return students.put(studentID, student);
	}

	@Override
	public List<Student> getAllStudents() {
		return new ArrayList<Student>(students.values());
	}

	@Override
	public Student getStudent(String studentID) {
		return students.get(studentID);
	}

	@Override
	public Student removeStudent(String studentID) {
		Student removedStudent = students.remove(studentID);
		return removedStudent;
	}

}
