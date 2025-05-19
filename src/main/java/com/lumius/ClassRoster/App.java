package com.lumius.ClassRoster;

import com.lumius.ClassRoster.controller.ClassRosterController;
import com.lumius.ClassRoster.ui.ClassRosterView;
import com.lumius.ClassRoster.ui.UserIO;
import com.lumius.ClassRoster.ui.UserIOConsoleImpl;
import com.lumius.ClassRoster.dao.ClassRosterDao;
import com.lumius.ClassRoster.dao.ClassRosterDaoFileImpl;

/**
 * Program entry point.
 * Instantiates the controller and calls run to begin the program
 */
public class App 
{
    public static void main( String[] args )
    {
    	UserIO myIo = new UserIOConsoleImpl();
    	ClassRosterView myView = new ClassRosterView(myIo);
    	
    	ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        ClassRosterController controller = new ClassRosterController(myView, myDao);
        controller.run();
    }
}
