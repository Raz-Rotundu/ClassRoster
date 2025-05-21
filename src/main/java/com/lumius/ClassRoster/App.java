package com.lumius.ClassRoster;

import com.lumius.ClassRoster.controller.ClassRosterController;
import com.lumius.ClassRoster.ui.ClassRosterView;
import com.lumius.ClassRoster.ui.UserIO;
import com.lumius.ClassRoster.ui.UserIOConsoleImpl;
import com.lumius.ClassRoster.dao.ClassRosterDao;
import com.lumius.ClassRoster.dao.ClassRosterDaoFileImpl;
import com.lumius.ClassRoster.service.ClassRosterServiceLayer;
import com.lumius.ClassRoster.service.ClassRosterServiceLayerImpl;

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
    	ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl();
        ClassRosterController controller = new ClassRosterController(myView, myService);
        controller.run();
    }
}
