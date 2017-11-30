package com.epam.lab.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epam.lab.dao.StudentDao;
import com.epam.lab.driver.Connecting;
import com.epam.lab.entity.Student;

public class StudentDaoImpl implements StudentDao {
	private Student executeStudentFromResultSet(ResultSet rs) throws SQLException {
		Student student = new Student();
		student.setId(rs.getInt("id"));
		student.setFirstName(rs.getString("first_name"));
		student.setLastName(rs.getString("surname"));
		student.setBirthday(rs.getDate("birthday"));
		student.setAdress(rs.getString("adress"));
		student.setPhone(rs.getString("phone_number"));
		student.setStudenBookId(rs.getInt("student_gradebook"));
		student.setDepartmentId(rs.getInt("department_id"));
		return student;
	}

	@Override
	public Student getOne(int id) throws SQLException {
		try (Connection connection = Connecting.getConnection()) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student where id=" + id);
			if (rs.next()) {
				return executeStudentFromResultSet(rs);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public List<Student> getAll() throws SQLException {
		try (Connection connection = Connecting.getConnection()) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from student");
			List<Student> students = new ArrayList<>();
			while (rs.next()) {
				Student student = executeStudentFromResultSet(rs);
				students.add(student);
			}
			return students;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public boolean insertIntoTable(Student student) {
		try (Connection connection = Connecting.getConnection()) {
			PreparedStatement ps = connection.prepareStatement("insert into student values (null,?,?,?,?,?,?,?");
			ps.setString(1, student.getFirstName());
			ps.setString(2, student.getLastName());
			ps.setDate(3, student.getBirthday());
			ps.setString(4, student.getAdress());
			ps.setString(5, student.getPhone());
			ps.setInt(6, student.getStudenBookId());
			ps.setInt(7, student.getDepartmentId());
			int rowsUpdate = ps.executeUpdate();
			if (rowsUpdate == 1) {
				return true;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

	@Override
	public boolean updateTable(Student student) {
		try (Connection connection = Connecting.getConnection()) {
			PreparedStatement ps = connection.prepareStatement(
					"update student set first_name=?, surname=?, birthday=?, adress=?, phone_number=?, student_gradebook=?, department_id=? where id=?");
			ps.setString(1, student.getFirstName());
			ps.setString(2, student.getLastName());
			ps.setDate(3, student.getBirthday());
			ps.setString(4, student.getAdress());
			ps.setString(5, student.getPhone());
			ps.setInt(6, student.getStudenBookId());
			ps.setInt(7, student.getDepartmentId());
			ps.setInt(8, student.getId());
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

	@Override
	public boolean deleteFromTable(int id) {
		try (Connection connection = Connecting.getConnection()) {
			Statement stmt = connection.createStatement();
			int i = stmt.executeUpdate("delete from student where id=" + id);
			if (i == 1) {
				return true;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

	@Override
	public boolean UpdateStudentDepartment(int newId, int departmentId) {
		try (Connection connection = Connecting.getConnection()) {
			PreparedStatement ps = connection.prepareStatement("update student set department_id=? where department_id=" + departmentId);
			ps.setInt(1, newId );
			int result = ps.executeUpdate();
			if(result == 1) {
				return true;
			}
		} catch (Exception e) {
				e.getMessage();
			}
		return false;
	}

}
