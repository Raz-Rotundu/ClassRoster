package com.lumius.ClassRoster.ui;

import com.lumius.ClassRoster.dto.Student;

/**
 * Class representing the view level of the MVC paradigm
 * Displays the menu and gets the user's selection
 */
public class ClassRosterView {
	private UserIO io = new UserIOConsoleImpl();
	
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
	
	/**
	 * Prints a banner indicating the next interaction will be for creating a student
	 */
	public void displayCreateStudentBanner() {
		io.print("=+= Create Student ==+");
	}
	
	/**
	 * Prints message confirming student was successfully created
	 */
	public void displayCreateSuccessBanner() {
		io.readString("Student successfully created. Press enter to continue");
	}
	
}
