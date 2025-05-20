package com.lumius.ClassRoster.dao;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.lumius.ClassRoster.dto.Student;

/**
 * DAO implementation class for the ClassRoster.
 * Stores roster entries as a map, reads and writes roster to file
 * Maintains persistence after adding and removing students
 */
public class ClassRosterDaoFileImpl implements ClassRosterDao{
	
	private static final String ROSTER_FILE = "roster.txt";
	private static final String DELIMITER = "::";
	private final Map<String, Student> students = new HashMap<>();
	
	@Override
	public Student addStudent(String studentID, Student student) throws ClassRosterPersistenceException {
		loadRoster();
	
		Student newStudent = students.put(studentID, student);
		
		writeRoster();
		
		return newStudent;
	}

	@Override
	public List<Student> getAllStudents() throws ClassRosterPersistenceException {
		loadRoster();
		return new ArrayList<Student>(students.values());
	}

	@Override
	public Student getStudent(String studentID) throws ClassRosterPersistenceException {
		loadRoster();
		return students.get(studentID);
	}

	@Override
	public Student removeStudent(String studentID) throws ClassRosterPersistenceException {
		loadRoster();
		Student removedStudent = students.remove(studentID);
		writeRoster();
		return removedStudent;
	}
	
	/**
	 * Deserializes a string representation of a student into a student object.
	 * Line is split on the delimiter "::" and stored into array of strings called studentTokens
	 * @param studentAsText a string representation of a student object (ID::Fname::Lname::Stream)
	 * @return A deserialized Student object
	 */
	private Student unmarshalStudent(String studentAsText) {
		String[] studentTokens = studentAsText.split(DELIMITER);
		
		// Getting ID and creating student object
		String studentId = studentTokens[0];
		Student studentFromFile = new Student(studentId);
		
		// Setting the rest of the values
		studentFromFile.setFirstName(studentTokens[1]);
		studentFromFile.setLastName(studentTokens[2]);
		studentFromFile.setCohort(studentTokens[3]);
		
		return studentFromFile;
	}
	
	/**
	 * Iterates through the lines of the ROSTER_FILE (roster.txt), deserializing each line and adding the student to the map
	 * @throws ClassRosterPersistenceException a translated FileNotFoundException
	 */
	public void loadRoster() throws ClassRosterPersistenceException{
		Scanner scanner = null;
		try {
			scanner = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));
			
			String currentLine;
			Student currentStudent;
			
			// Iterate line by line, deserializing and storing student into map
			while(scanner.hasNextLine()) {
				currentLine = scanner.nextLine();
				currentStudent = unmarshalStudent(currentLine);
				students.put(currentStudent.getStudentID(), currentStudent);
				
			}
		// Catch FileNotFound exception and translate to application exception
		} catch (FileNotFoundException e) {
			throw new ClassRosterPersistenceException("Could not load data into memory", e);
		}
		// Close scanner at end
		finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
	
	/**
	 * Serializes a Student object into a text representation
	 * @param aStudent the student object to be serialized
	 * @return the string representation of the student object
	 */
	private String marshalStudent(Student aStudent) {
		// Concatenate various field values
		String studentAsText = aStudent.getStudentID() + DELIMITER;
		studentAsText += aStudent.getFirstName() + DELIMITER;
		studentAsText += aStudent.getLastName() + DELIMITER;
		studentAsText += aStudent.getCohort();
		
		return studentAsText;
		
	}
	
	/**
	 * Iterate through the Students currently in memory, serializing and writing them to file
	 * @throws ClassRosterPersistenceException an IOException translated to application specific exception
	 */
	public void writeRoster() throws ClassRosterPersistenceException {
		PrintWriter out = null;
		
		try {
			out = new PrintWriter(new FileWriter(ROSTER_FILE));
			String studentAsText;
			List<Student> studentList = new ArrayList<Student>(students.values());
			for (Student currentStudent : studentList) {
				studentAsText = marshalStudent(currentStudent);
				
				// Write student to file and force printWriter to write
				out.println(studentAsText);
				out.flush();
			}
		} catch (IOException e) {
			throw new ClassRosterPersistenceException("Could not save student to data", e);
		}
		finally {
			if(out != null) {
				out.close();
			}
		}
	}
}
