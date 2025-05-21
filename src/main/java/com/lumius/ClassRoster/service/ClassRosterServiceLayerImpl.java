package com.lumius.ClassRoster.service;

import java.util.List;

import com.lumius.ClassRoster.dao.ClassRosterAuditDao;
import com.lumius.ClassRoster.dao.ClassRosterDao;
import com.lumius.ClassRoster.dao.ClassRosterPersistenceException;
import com.lumius.ClassRoster.dto.Student;

public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer{
	ClassRosterDao dao;
	private final ClassRosterAuditDao auditDao;
	
	public ClassRosterServiceLayerImpl(ClassRosterDao dao, ClassRosterAuditDao auditDao) {
		this.dao = dao;
		this.auditDao = auditDao;
		
	}
	
	@Override
	public void createStudent(Student student) throws ClassRosterDuplicateIdException,
			ClassRosterDataValidationException, ClassRosterPersistenceException {
		
		// Check if student's ID already exists
		if(dao.getStudent(student.getStudentID())!= null) {
			throw new ClassRosterDuplicateIdException(
					"ERROR: Could not create student. Id " + student.getStudentID() + " already exists");	
		}
		
		// Check if all fields are filled
		validateStudentData(student);
		
		
		dao.addStudent(student.getStudentID(), student);
		
		auditDao.writeAuditEntry("Student " + student.getStudentID() + " CREATED.");
	}

	@Override
	public List<Student> getAllStudents() throws ClassRosterPersistenceException {
		return dao.getAllStudents();
	}
	
	@Override
	public Student getStudent(String studentId) throws ClassRosterPersistenceException {
		return dao.getStudent(studentId);
	}

	@Override
	public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
		Student removedStudent =  dao.removeStudent(studentId);
		
		auditDao .writeAuditEntry("Student " + student.getStudentID() + " DELETED.");
		
		return removedStudent;
	}
	
	/**
	 * Function which verifies that the given student has no null or empty first, last name and cohort fields
	 * @param student the Student object to be verified
	 * @throws ClassRosterDataValidationException thrown if a students first, last name, or stream are blank
	 */
	private void validateStudentData(Student student) throws ClassRosterDataValidationException{
		if(student.getFirstName() == null
				|| student.getFirstName().trim().length() == 0
				|| student.getLastName() == null
				|| student.getLastName().trim().length() == 0
				|| student.getCohort() == null
				|| student.getCohort().trim().length() == 0
				) {
			throw new ClassRosterDataValidationException("ERROR: All fields [FIrst Name, Last Name, Cohort] must be filled");
		}
	}
}
