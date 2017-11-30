package com.epam.lab.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.epam.lab.daoImpl.SubjectDaoImpl;
import com.epam.lab.entity.Subject;

public class SubjectService {

	public Subject getSubject() throws SQLException {
		SubjectDaoImpl subjectDaoImpl = new SubjectDaoImpl();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id of subject");
		int id = scanner.nextInt();
		return subjectDaoImpl.getOne(id);
	}

	public List<Subject> getAll() throws SQLException {
		SubjectDaoImpl subjectDaoImpl = new SubjectDaoImpl();
		return subjectDaoImpl.getAll();
	}

	public boolean inserIntoSubject(String name, String description) {
		SubjectDaoImpl subjectDaoImpl = new SubjectDaoImpl();
		Subject subject = new Subject(name, description);
		return subjectDaoImpl.insertIntoTable(subject);
	}

	public boolean updateSubject(int id, String name, String description) {
		SubjectDaoImpl subjectDaoImpl = new SubjectDaoImpl();
		Subject subject = new Subject(id, name, description);
		return subjectDaoImpl.updateTable(subject);
	}
	public boolean deleteSubject() {
		SubjectDaoImpl subjectDaoImpl = new SubjectDaoImpl();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id of subject");
		int id = scanner.nextInt();
		return subjectDaoImpl.deleteFromTable(id);
	}

}
