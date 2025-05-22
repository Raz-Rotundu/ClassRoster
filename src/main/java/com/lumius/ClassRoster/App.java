package com.lumius.ClassRoster;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lumius.ClassRoster.controller.ClassRosterController;

/**
 * Program entry point.
 * Instantiates the controller and calls run to begin the program
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    	
    	ClassRosterController controller = ctx.getBean("controller", ClassRosterController.class);
        controller.run();
        
    }
}
