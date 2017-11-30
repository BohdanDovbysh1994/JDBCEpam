package com.epam.lab.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.epam.lab.entity.Exam;
import com.epam.lab.service.ExamService;

public class ExamController {
	public void examMenu() throws SQLException {
		ExamService examService = new ExamService();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		boolean work = true;
		while (work) {
			System.out.println("Press 1 for getExam");
			System.out.println("Press 2 for get all exams");
			System.out.println("Press 3 for insert into exam");
			System.out.println("Press 4 for update exam");
			System.out.println("Press 5 for delete exam");
			System.out.println("Press 6 for exit");
			String sc = scanner.next();
			switch (sc) {
			case "1": {
				System.out.println(examService.getExam());
				break;
			}
			case "2": {
				List<Exam> all = examService.getAllExams();
				for (Exam exam : all) {
					System.out.println(exam);
				}
				break;
			}
			case "3": {
				System.out.println("Enter studentId");
				Integer studentId = scanner.nextInt();
				System.out.println("Enter subjectId");
				Integer subjectId = scanner.nextInt();
				System.out.println("Enter date like yyyy-mm-dd");
				String date = scanner.next();
				System.out.println("Enter mark");
				Integer mark = scanner.nextInt();
				examService.insertIntoExam(studentId, subjectId, date, mark);
				break;
			}
			case "4": {
				System.out.println("Enter examId");
				Integer id = scanner.nextInt();
				System.out.println("Enter studentId");
				Integer studentId = scanner.nextInt();
				System.out.println("Enter subjectId");
				Integer subjectId = scanner.nextInt();
				System.out.println("Enter date like yyyy-mm-dd");
				String date = scanner.next();
				System.out.println("Enter mark");
				Integer mark = scanner.nextInt();
				examService.updateExam(id, studentId, subjectId, date, mark);
				break;
			}
			case "5": {
				examService.deleteExam();
				break;
			}
			case "6": {
				System.exit(0);
			}
			default:
				System.out.println("Try again");
				examMenu();

			}
		}
	}
}
