package com.epam.lab.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.epam.lab.entity.Subject;
import com.epam.lab.service.SubjectService;

public class SubjectController {
	public void menuSubject() throws SQLException {
	SubjectService subjectService = new SubjectService();
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);
	boolean work = true;
	while(work) {
		System.out.println("Press 1 for getSubject");
		System.out.println("Press 2 for get all subjects");
		System.out.println("Press 3 for insert into subject");
		System.out.println("Press 4 for update subject");
		System.out.println("Press 5 for delete subject");
		System.out.println("Press 6 for exit");
		String sc = scanner.next();
			switch (sc) {
			case "1": {
				System.out.println(subjectService.getSubject());
				break;
			}
			case "2": {
				List<Subject> all = subjectService.getAll();
				for (Subject subject : all) {
					System.out.println(subject);
				}
				break;
			}
			case "3": {
				System.out.println("Enter name");
				String name = scanner.next();
				System.out.println("Enter description");
				String description = scanner.next();
				subjectService.inserIntoSubject(name, description);
				break;
			}
			case "4": {
				System.out.println("Enter id");
				int id = scanner.nextInt();
				System.out.println("Enter name");
				String name = scanner.next();
				System.out.println("Enter description");
				String description = scanner.next();
				subjectService.updateSubject(id, name, description);
				break;
			}
			case "5": {
				subjectService.deleteSubject();
				break;
			}
			case "6": {
				System.exit(0);
			}
			default:
				System.out.println("Try again");
				menuSubject();

			}
	}
	
	}
}
