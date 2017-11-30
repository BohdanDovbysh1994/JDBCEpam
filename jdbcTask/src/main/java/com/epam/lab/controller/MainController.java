package com.epam.lab.controller;

import java.sql.SQLException;
import java.util.Scanner;

public class MainController {

	public static void main(String[] args) throws SQLException {
		StudentController studentController = new StudentController();
		DepartmentController departmentController = new DepartmentController();
		GradebookController gradebookController = new GradebookController();
		SubjectController subjectController = new SubjectController();
		ExamController examController = new ExamController();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		boolean work = true;
		while(work) {
			System.out.println("Press 1 for student menu");
			System.out.println("Press 2 for department menu");
			System.out.println("Press 3 for gardebook menu");
			System.out.println("Press 4 for subject menu");
			System.out.println("Press 5 for exam menu");
			System.out.println("Press any other key for exit");
			String key = scanner.next();
			switch (key) {
			case "1":{
				studentController.menuStudent();
				break;
			}
			case "2":{
				departmentController.menuDepartment();
			break;
			}
			case "3":{
				gradebookController.menuGradebooks();
				break;
			}
			case "4":{
				subjectController.menuSubject();
				break;
			}
			case "5": {
				examController.examMenu();
				break;
			}

			default:
				System.exit(0);
				break;
			}
		}

	}

}
