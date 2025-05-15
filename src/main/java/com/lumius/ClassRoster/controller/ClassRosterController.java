package com.lumius.ClassRoster.controller;

import java.util.List;

import com.lumius.ClassRoster.dao.ClassRosterDao;
import com.lumius.ClassRoster.dao.ClassRosterDaoFileImpl;
import com.lumius.ClassRoster.dto.Student;
import com.lumius.ClassRoster.ui.ClassRosterView;
import com.lumius.ClassRoster.ui.UserIO;
import com.lumius.ClassRoster.ui.UserIOConsoleImpl;


/**
 * This class represents the controller in the MVC paradigm. It is responsible for displaying the menu,
 * parsing the user's choices, and the calling the appropriate function based on that choice.
 */
public class ClassRosterController {
	
	private ClassRosterView view = new ClassRosterView();
	private ClassRosterDao dao = new ClassRosterDaoFileImpl();
	private UserIO io = new UserIOConsoleImpl();
	
	public void run() {
		boolean keepGoing = true;
		int menuSelection = 0;
		while(keepGoing) {

			menuSelection = getMenuSelection();
			
			switch(menuSelection) {
				case 1: 
					listStudents();
					break;
				case 2:
					createStudent();
					break;
				case 3:
					viewStudent();
					break;
				case 4:
					io.print("REMOVE STUDENT");
					break;
				case 5:
					keepGoing = false;
					break;
				default:
					io.print("UNKNOWN COMMAND");
			}
		}
		io.print("GOODBYE");
//		io.close();
	}
	
	/**
	 * Orchestrates the creation of a new student by getting user input from view,
	 * creating Student DTO and adding it to DAO, then having view display the relevant success banners.
	 */
	private void createStudent() {
		view.displayCreateStudentBanner();
		Student newStudent = view.getNewStudentInfo();
		dao.addStudent(newStudent.getStudentID(), newStudent);
		view.displayCreateSuccessBanner();
		
	}
	
	/**
	 * Orchestrates displaying of new student by getting list of students from DAO, and passing it to view
	 */
	private void listStudents() {
		view.displayDisplayAllBanner();
		List<Student> studentList = dao.getAllStudents();
		view.displayStudentList(studentList);
	}
	
	/**
	 * Gets user's chosen ID from the view, uses to retrieve correct Student object from dao, then passes it back to view
	 */
	private void viewStudent() {
		view.displayDisplayStudentBanner();
		String id = view.getStudentIdChoice();
		Student student = dao.getStudent(id);
		view.displayStudent(student);
	}
	
	/**
	 * Uses the view to print the options menu
	 * @return the selection the user chose
	 */
	private int getMenuSelection() {
		return view.printMenuAndGetSelection();
	}
	

}
