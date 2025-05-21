package com.lumius.ClassRoster.dao;

/**
 * Interface for logging operations
 * Has one method, which writes a given message to log file
 */
public interface ClassRosterAuditDao {

	/**
	 * Writes entry to log
	 * @param entry text of the entry to be written
	 * @throws ClassRosterPersistenceException when encountering error reading/writing to log file
	 */
	public void writeAuditEntry(String entry) throws ClassRosterPersistenceException;
}
