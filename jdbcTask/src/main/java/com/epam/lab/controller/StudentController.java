package com.epam.lab.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.epam.lab.entity.Student;
import com.epam.lab.service.StudentService;

public class StudentController {

	public void menuStudent() throws SQLException {
		StudentService studentService = new StudentService();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		boolean work = true;
		while (work) {
			System.out.println("Press 1 for getStudent");
			System.out.println("Press 2 for get all students");
			System.out.println("Press 3 for insert into student");
			System.out.println("Press 4 for update student");
			System.out.println("Press 5 for delete student");
			System.out.println("Press 6 for exit");
			String sc = scanner.next();
			switch (sc) {
			case "1": {
				System.out.println(studentService.getStudent());
				break;
			}
			case "2": {
				List<Student> all = studentService.getAllStudents();
				for (Student student : all) {
					System.out.println(student);
				}
				break;
			}
			case "3": {
				studentService.insertIntoStudent();
				break;
			}
			case "4": {
				studentService.updateStudent();
				break;
			}
			case "5": {
				studentService.deleteStudent();
				break;
			}
			case "6": {
				System.exit(0);
			}
			default:
				System.out.println("Try again");
				menuStudent();

			}
		}
	}

}
