package com.epam.lab.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.epam.lab.daoImpl.StudentDaoImpl;
import com.epam.lab.entity.Student;

public class StudentService {

	public Student getStudent() throws SQLException {
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id of student");
		int id = scanner.nextInt();
		return studentDaoImpl.getOne(id);
	}

	public List<Student> getAllStudents() throws SQLException {
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		return studentDaoImpl.getAll();
	}

	public boolean insertIntoStudent() {
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter student name");
		String firstName = scanner.next();
		System.out.println("Enter student surname");
		String lastName = scanner.next();
		System.out.println("Enter birthday like yyyy-mm-dd");
		String birthday = scanner.next();
		System.out.println("Enter student adress");
		String adress = scanner.next();
		System.out.println("Enter student phone like 099-99-99-999");
		String phone = scanner.next();
		System.out.println("Enter student gradebook id");
		Integer studenBookId = scanner.nextInt();
		System.out.println("Enter student department id");
		Integer departmentId = scanner.nextInt();
		Student student = new Student(firstName, lastName, Date.valueOf(birthday), adress, phone, studenBookId,
				departmentId);
		return studentDaoImpl.insertIntoTable(student);
	}

	public boolean updateStudent() {
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter student id");
		Integer id = scanner.nextInt();
		System.out.println("Enter student name");
		String firstName = scanner.next();
		System.out.println("Enter student surname");
		String lastName = scanner.next();
		System.out.println("Enter birthday like yyyy-mm-dd");
		String birthday = scanner.next();
		System.out.println("Enter student adress");
		String adress = scanner.next();
		System.out.println("Enter student phone like 099-99-99-999");
		String phone = scanner.next();
		System.out.println("Enter student gradebook id");
		Integer studenBookId = scanner.nextInt();
		System.out.println("Enter student department id");
		Integer departmentId = scanner.nextInt();
		Student student = new Student(id, firstName, lastName, Date.valueOf(birthday), adress, phone, studenBookId, departmentId);
		return studentDaoImpl.updateTable(student);
	}
	public boolean deleteStudent() {
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id of student");
		int id = scanner.nextInt();
		return studentDaoImpl.deleteFromTable(id);
	}
	
	public boolean updateStudentDepartment() {
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id of student department");
		int id = scanner.nextInt();
		System.out.println("Enter new id of department");
		int newId = scanner.nextInt();
		return studentDaoImpl.UpdateStudentDepartment(newId, id);
	}
}
