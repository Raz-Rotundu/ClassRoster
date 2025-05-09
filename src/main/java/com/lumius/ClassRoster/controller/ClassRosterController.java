package com.lumius.ClassRoster.controller;

import com.lumius.ClassRoster.ui.ClassRosterView;
import com.lumius.ClassRoster.ui.UserIO;
import com.lumius.ClassRoster.ui.UserIOConsoleImpl;


/**
 * This class represents the controller in the MVC paradigm. It is responsible for displaying the menu,
 * parsing the user's choices, and the calling the appropriate function based on that choice.
 */
public class ClassRosterController {
	
	private ClassRosterView view = new ClassRosterView();
	private UserIO io = new UserIOConsoleImpl();
	
	public void run() {
		boolean keepGoing = true;
		int menuSelection = 0;
		while(keepGoing) {

			menuSelection = getMenuSelection();
			
			switch(menuSelection) {
				case 1: 
					io.print("LIST STUDENTS");
					break;
				case 2:
					io.print("CREATE STUDENT");
					break;
				case 3:
					io.print("VIEW STUDENT");
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
	
	private int getMenuSelection() {
		return view.printMenuAndGetSelection();
	}
	

}
