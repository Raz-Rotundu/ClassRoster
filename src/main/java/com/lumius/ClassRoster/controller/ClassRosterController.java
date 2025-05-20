package com.lumius.ClassRoster.controller;

import java.util.List;

import com.lumius.ClassRoster.dao.ClassRosterDao;
import com.lumius.ClassRoster.dao.ClassRosterPersistenceException;
import com.lumius.ClassRoster.dao.ClassRosterDaoFileImpl;
import com.lumius.ClassRoster.dto.Student;
import com.lumius.ClassRoster.service.ClassRosterDataValidationException;
import com.lumius.ClassRoster.service.ClassRosterDuplicateIdException;
import com.lumius.ClassRoster.service.ClassRosterServiceLayer;
import com.lumius.ClassRoster.ui.ClassRosterView;
import com.lumius.ClassRoster.ui.UserIO;
import com.lumius.ClassRoster.ui.UserIOConsoleImpl;


/**
 * This class represents the controller in the MVC paradigm. It is responsible for displaying the menu,
 * parsing the user's choices, and the calling the appropriate function based on that choice.
 */
public class ClassRosterController {
	

	
	private ClassRosterView view;
	private ClassRosterServiceLayer service;
	private UserIO io = new UserIOConsoleImpl();
	
	/**
	 * Constructor using dependancy injection
	 * @param view the implementation of ClassRosterView
	 * @param dao the implementation of ClassRosterDao
	 */
	public ClassRosterController(ClassRosterView view, ClassRosterServiceLayer service) {
		this.view = view;
		this.service = service;
	}
	
	public void run() {
		boolean keepGoing = true;
		int menuSelection = 0;
		try {
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
						removeStudent();
						break;
					case 5:
						keepGoing = false;
						break;
					default:
						unknownCommand();
				}
			}
			exitMessage();
		} catch (ClassRosterPersistenceException e) {
			view.displayErrorMessage(e.getMessage());
		}
	}
	
	
	/**
	 * Orchestrates the creation of a new student by getting user input from view,
	 * then having the service validate and add student to roster
	 * @throws ClassRosterPersistenceException if there is an error reading or writing to file
	 */
	private void createStudent() throws ClassRosterPersistenceException {
		view.displayCreateStudentBanner();
		boolean hasErrors = false;
		do {
			Student currentStudent = view.getNewStudentInfo();
			try {
				service.createStudent(currentStudent);
				view.displayCreateSuccessBanner();
				hasErrors = false;
				
			} catch (ClassRosterDuplicateIdException | ClassRosterDataValidationException e) {
				hasErrors = true;
				view.displayErrorMessage(e.getMessage());
			}
		} while(hasErrors);
	}
	
	/**
	 * Orchestrates displaying of new student by getting list of students from DAO, and passing it to view
	 */
	private void listStudents() throws ClassRosterPersistenceException {
		view.displayDisplayAllBanner();
		List<Student> studentList = service.getAllStudents();
		view.displayStudentList(studentList);
	}
	
	/**
	 * Gets user's chosen ID from the view, uses to retrieve correct Student object from dao, then passes it back to view
	 */
	private void viewStudent() throws ClassRosterPersistenceException {
		view.displayDisplayStudentBanner();
		String id = view.getStudentIdChoice();
		Student student = service.getStudent(id);
		view.displayStudent(student);
	}
	
	/**
	 * Get chosen ID from view, remove that student from the dao, then display the results
	 */
	private void removeStudent() throws ClassRosterPersistenceException {
		view.displayRemoveStudentBanner();
		String id = view.getStudentIdChoice();
		Student removedStudent = service.removeStudent(id);
		view.displayRemoveResult(removedStudent);
	}
	/**
	 * Uses the view to print the options menu
	 * @return the selection the user chose
	 */
	private int getMenuSelection() {
		return view.printMenuAndGetSelection();
	}
	
	/**
	 * Displays Unknown command banner in the view
	 */
	private void unknownCommand() {
		view.displayUnknownCmdBanner();
	}
	
	/**
	 * Displays goodbye message in the view
	 */
	private void exitMessage() {
		view.displayExitBanner();
	}
}
