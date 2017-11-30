package com.epam.lab.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.epam.lab.daoImpl.GradeBookDaoImpl;
import com.epam.lab.entity.GradeBook;

public class GradeBookService {
	public GradeBook getGradebook() throws SQLException {
		GradeBookDaoImpl gradeBookDaoImpl = new GradeBookDaoImpl();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id of gradebook");
		int id = scanner.nextInt();
		return gradeBookDaoImpl.getOne(id);
	}

	public List<GradeBook> getAllGradebooks() throws SQLException {
		GradeBookDaoImpl gradeBookDaoImpl = new GradeBookDaoImpl();
		return gradeBookDaoImpl.getAll();
	}

	public boolean insertIntoGradebook(String date, String group, Integer course) {
		GradeBookDaoImpl gradeBookDaoImpl = new GradeBookDaoImpl();
		GradeBook gradeBook = new GradeBook(Date.valueOf(date), group, course);
		return gradeBookDaoImpl.insertIntoTable(gradeBook);
	}

	public boolean updateGradebook(Integer id, String date, String group, Integer course) {
		GradeBookDaoImpl gradeBookDaoImpl = new GradeBookDaoImpl();
		GradeBook gradeBook = new GradeBook(id, Date.valueOf(date), group, course);
		return gradeBookDaoImpl.updateTable(gradeBook);
	}
	public boolean deleteGradebook() {
		GradeBookDaoImpl gradeBookDaoImpl = new GradeBookDaoImpl();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id of gradebook");
		int id = scanner.nextInt();
		return gradeBookDaoImpl.deleteFromTable(id);
	}
}
