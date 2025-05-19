package com.lumius.ClassRoster.dao;

/**
 * Custom exception class for ClassRoster
 * Hides implementation exceptions
 */
public class ClassRosterDaoException extends Exception {
	
	/**
	 * Constructor for when something has gone wrong, but wasn't caused by another exception
	 * @param message error message
	 */
	public ClassRosterDaoException(String message) {
		super(message);
	}
	
	/**
	 * Constructor for when something has gone wrong because of an exception from the underlying implementation
	 * @param message the error message
	 * @param cause the underlying cause for error
	 */
	public ClassRosterDaoException(String message, Throwable cause) {
		super(message, cause);
	}
}
