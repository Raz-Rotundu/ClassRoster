package com.lumius.ClassRoster.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class ClassRosterAuditDaoFileImpl implements ClassRosterAuditDao {

	public static final String AUDIT_FILE = "audit.txt";
	
	@Override
	public void writeAuditEntry(String entry) throws ClassRosterPersistenceException {
		PrintWriter out;
		
		try {
			out = new PrintWriter(new FileWriter(AUDIT_FILE, true)); // append mode
		} catch (IOException e) {
			throw new ClassRosterPersistenceException("Could not write to audit file", e);
		}
		
		LocalDateTime timestamp = LocalDateTime.now();
		out.println(timestamp.toString() + " : " + entry);
		
		out.close();
	}

}
