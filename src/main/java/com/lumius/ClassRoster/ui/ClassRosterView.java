package com.lumius.ClassRoster.ui;


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
	
}
