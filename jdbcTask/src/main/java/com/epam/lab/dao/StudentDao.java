package com.epam.lab.dao;

import com.epam.lab.entity.Student;

public interface StudentDao extends GenericDao<Student> {
	boolean UpdateStudentDepartment(int newId, int departmentId);
}
