package com.epam.lab.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.epam.lab.daoImpl.ExamDaoImpl;
import com.epam.lab.entity.Exam;

public class ExamService {
	public Exam getExam() throws SQLException {
		ExamDaoImpl examDaoImpl = new ExamDaoImpl();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id of gradebook");
		int id = scanner.nextInt();
		return examDaoImpl.getOne(id);
	}

	public List<Exam> getAllExams() throws SQLException {
		ExamDaoImpl examDaoImpl = new ExamDaoImpl();
		return examDaoImpl.getAll();
	}

	public boolean insertIntoExam(Integer studentId, Integer subjectId, String date, Integer mark) {
		ExamDaoImpl examDaoImpl = new ExamDaoImpl();
		Exam exam = new Exam(studentId, subjectId, Date.valueOf(date), mark);
		return examDaoImpl.insertIntoTable(exam);
	}

	public boolean updateExam(Integer id, Integer studentId, Integer subjectId, String date, Integer mark) {
		ExamDaoImpl examDaoImpl = new ExamDaoImpl();
		Exam exam = new Exam(id, studentId, subjectId, Date.valueOf(date), mark);
		return examDaoImpl.updateTable(exam);
	}

	public boolean deleteExam() {
		ExamDaoImpl examDaoImpl = new ExamDaoImpl();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id of gradebook");
		int id = scanner.nextInt();
		return examDaoImpl.deleteFromTable(id);
	}
}
