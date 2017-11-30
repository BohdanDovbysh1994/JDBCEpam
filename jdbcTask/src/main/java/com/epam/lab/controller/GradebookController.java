package com.epam.lab.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.epam.lab.entity.GradeBook;
import com.epam.lab.service.GradeBookService;

public class GradebookController {
	public void menuGradebooks() throws SQLException {
		GradeBookService gradeBookService = new GradeBookService();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		boolean work = true;
		while (work) {
			System.out.println("Press 1 for getGradebook");
			System.out.println("Press 2 for get all gradebooks");
			System.out.println("Press 3 for insert into gradebook");
			System.out.println("Press 4 for update gradebook");
			System.out.println("Press 5 for delete gradebook");
			System.out.println("Press 6 for exit");
			String sc = scanner.next();
			switch (sc) {
			case "1": {
				System.out.println(gradeBookService.getGradebook());
				break;
			}
			case "2": {
				List<GradeBook> all = gradeBookService.getAllGradebooks();
				for (GradeBook gradeBook : all) {
					System.out.println(gradeBook);
				}
				break;
			}
			case "3": {
				System.out.println("Enter date kike yyyy-mm-dd");
				String date = scanner.next();
				System.out.println("Enter group");
				String group = scanner.next();
				System.out.println("Enter cource");
				int course = scanner.nextInt();
				gradeBookService.insertIntoGradebook(date, group, course);
				break;
			}
			case "4": {
				System.out.println("Enter id");
				int id = scanner.nextInt();
				System.out.println("Enter date kike yyyy-mm-dd");
				String date = scanner.next();
				System.out.println("Enter group");
				String group = scanner.next();
				System.out.println("Enter cource");
				int course = scanner.nextInt();
				gradeBookService.updateGradebook(id, date, group, course);
				break;
			}
			case "5": {
				gradeBookService.deleteGradebook();
				break;
			}
			case "6": {
				System.exit(0);
			}
			default:
				System.out.println("Try again");
				menuGradebooks();

			}
		}
	}
}
