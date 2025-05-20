package com.lumius.ClassRoster.service;

/**
 * Exception thrown when Student fields are left blank
 */
public class ClassRosterDataValidationException extends Exception{

	public ClassRosterDataValidationException(String message) {
		super(message);
	}
	
	public ClassRosterDataValidationException(String message, Throwable cause) {
		super(message, cause);
	}
}
