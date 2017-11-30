package com.epam.lab.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.epam.lab.daoImpl.DepartmentDaoImpl;
import com.epam.lab.entity.Department;

public class DepartmentService{
	public Department getDepartment() throws SQLException {
		DepartmentDaoImpl departmentDaoImpl = new DepartmentDaoImpl();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id of department");
		int id = scanner.nextInt();
		return departmentDaoImpl.getOne(id);
	}
	public List<Department> getAll() throws SQLException {
		DepartmentDaoImpl departmentDaoImpl = new DepartmentDaoImpl();
		return departmentDaoImpl.getAll();
	}
	public boolean inserIntoDepartment(String name, String location) {
		DepartmentDaoImpl departmentDaoImpl = new DepartmentDaoImpl();
		Department department = new Department(name, location);
		return departmentDaoImpl.insertIntoTable(department);	
	}
	public boolean updateDepartment(int id, String name, String location) {
		DepartmentDaoImpl departmentDaoImpl = new DepartmentDaoImpl();
		Department department = new Department(id, name, location);
		return departmentDaoImpl.updateTable(department);
		
	}
	public boolean deleteDepartment() {
		DepartmentDaoImpl departmentDaoImpl = new DepartmentDaoImpl();
		StudentService studentService = new StudentService();
		studentService.updateStudentDepartment();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id of department");
		int id = scanner.nextInt();
		return departmentDaoImpl.deleteFromTable(id);
	}
	
	
	
}
