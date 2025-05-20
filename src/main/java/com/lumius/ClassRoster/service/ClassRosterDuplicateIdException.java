package com.lumius.ClassRoster.service;

/**
 * Exception thrown when there is a student with a duplicate ID in the roster
 */
public class ClassRosterDuplicateIdException extends Exception{
	public ClassRosterDuplicateIdException(String message) {
		super(message);
	}
	
	public ClassRosterDuplicateIdException(String message, Throwable cause) {
		super(message, cause);
	}
}
