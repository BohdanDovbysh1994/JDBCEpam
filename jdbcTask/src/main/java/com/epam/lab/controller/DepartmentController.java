package com.epam.lab.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.epam.lab.entity.Department;
import com.epam.lab.service.DepartmentService;

public class DepartmentController {
	
	
	public void menuDepartment() throws SQLException {
		DepartmentService service = new DepartmentService();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		boolean work = true;
		while(work) {
		System.out.println("Press 1 for getDepartment");
		System.out.println("Press 2 for get all departments");
		System.out.println("Press 3 for insert into department");
		System.out.println("Press 4 for update department");
		System.out.println("Press 5 for delete department");
		System.out.println("Press 6 for exit");
		System.out.println();
		String sc = scanner.next();
		switch (sc) {
		case "1":{
			System.out.println(service.getDepartment());
			break;
		}
		case "2":{
			List<Department> all = service.getAll();
		for (Department department : all) {
			System.out.println(department);
		}
			break;
		}
		case "3":{
			System.out.println("Enter name");
			String name = scanner.next();
			System.out.println("Enter location");
			String location = scanner.next();
			service.inserIntoDepartment(name, location);
			break;
		}
		case "4":{
			System.out.println("Enter id");
			int id = scanner.nextInt();
			System.out.println("Enter name");
			String name = scanner.next();
			System.out.println("Enter location");
			String location = scanner.next();
			service.updateDepartment(id, name, location);
			break;
		}
		case "5":{
			System.out.println(service.deleteDepartment());
			break;
		}
		case "6":{
			System.exit(0);
		}
		default:
			System.out.println("Try again");
			menuDepartment();
			
		}
	}
	}
}
