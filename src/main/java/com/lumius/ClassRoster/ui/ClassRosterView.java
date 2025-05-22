package com.lumius.ClassRoster.ui;

import com.lumius.ClassRoster.dto.Student;

import java.util.List;

import com.lumius.ClassRoster.dao.*;

/**
 * Class representing the view level of the MVC paradigm
 * Displays the menu and gets the user's selection
 */
public class ClassRosterView {
	final UserIO io;
	
	/**
	 * Constructor implementing dependency injection
	 * @param io the UserIO implementation to use
	 */
	public ClassRosterView(UserIO io) {
		this.io = io;
	}
	
	public int printMenuAndGetSelection() {
		io.print("Main Menu");
		io.print("1. List Students");
		io.print("2. Create New Student");
		io.print("3. View a Student");
		io.print("4. Remove a Student");
		io.print("5. Exit");
		
		return io.readInt("Please Select from the above choices.");
	}
	
	/**
	 * Prompts the user for a student ID, first name, last name ,and cohort. Returns newly created Student object.
	 * @return newly created Student object
	 */
	public Student getNewStudentInfo() {
		Student currentStudent = new Student(io.readString("Enter new student ID"));
		currentStudent.setFirstName(io.readString("Enter new student first name"));
		currentStudent.setLastName(io.readString("Enter new student last name"));
		currentStudent.setCohort(io.readString("Enter new student cohort"));
		
		return currentStudent;
	}
	
	public void displayErrorMessage(String errorMsg) {
		io.print("== ERROR ==");
		io.print(errorMsg);
	}
	
	/**
	 * Takes a list of students and displays the information about each student to the console
	 * @param studentList
	 */
	public void displayStudentList(List<Student> studentList) {
		for (Student currentStudent : studentList) {
			String studentInfo = String.format("#%s : %s %s, %s", 
					currentStudent.getStudentID(),
					currentStudent.getFirstName(),
					currentStudent.getLastName(),
					currentStudent.getCohort());
			io.print(studentInfo);
		}
		io.readString("Press Enter to continue");
	}
	
	/**
	 * Displays a single student's information to the user
	 * @param student The student whose information is being displayed
	 */
	public void displayStudent(Student student) {
		if (student != null) {
			io.print(student.getStudentID());
			io.print(student.getFirstName());
			io.print(student.getLastName());
			io.print(student.getCohort());
			io.print("");
		} else {
			io.print("No such student.");
		}
		io.readString("Press enter to continue.");
	}
	
	/**
	 * Displays the results of a student removal to console
	 * @param studentRecord the student which was removed
	 */
	public void displayRemoveResult(Student studentRecord) {
		if(studentRecord != null) {
			io.print("Student removed");
		} else {
			io.print("No such student");
		}
		io.readString("Press enter to continue.");
	}
	
	
	/**
	 * Prints banner with goodbye message
	 */
	public void displayExitBanner() {
		io.print("Bye");
	}
	
	/**
	 * Prints banner indicating unknown commmand
	 */
	public void displayUnknownCmdBanner() {
		io.print("Unknown command!");
	}
	
	/**
	 * Prints banner indicating next interaction is for removing student
	 */
	public void displayRemoveStudentBanner() {
		io.print("=== Remove Student ===");
	}
	
	/**
	 * Prints banner indicating next interaction is for getting student info
	 */
	public void displayDisplayStudentBanner() {
		io.print("=== Display Student ===");
	}
	
	/**
	 * Asks user for ID of the students to display
	 * @return the ID chosen by the user
	 */
	public String getStudentIdChoice() {
		return io.readString("Enter the Student ID");
	}
	
	
	/**
	 * Prints banner indication next interaction is for getting all students in roster
	 */
	public void displayDisplayAllBanner() {
		io.print("=== Display All Students ===");
	}
	/**
	 * Prints a banner indicating the next interaction will be for creating a student
	 */
	public void displayCreateStudentBanner() {
		io.print("+== Create Student ==+");
	}
	
	/**
	 * Prints message confirming student was successfully created
	 */
	public void displayCreateSuccessBanner() {
		io.readString("Student successfully created. Press enter to continue");
	}
	
}
