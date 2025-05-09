package com.lumius.ClassRoster;

import com.lumius.ClassRoster.controller.ClassRosterController;

/**
 * Program entry point.
 * Instantiates the controller and calls run to begin the program
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassRosterController controller = new ClassRosterController();
        controller.run();
    }
}
