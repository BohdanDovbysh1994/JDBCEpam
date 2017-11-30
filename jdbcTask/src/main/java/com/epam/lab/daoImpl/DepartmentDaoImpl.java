package com.epam.lab.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epam.lab.dao.DepartmentDao;
import com.epam.lab.driver.Connecting;
import com.epam.lab.entity.Department;

public class DepartmentDaoImpl implements DepartmentDao {
	private Department extractDepartmentFromResaltSet(ResultSet rs) throws SQLException {
		Department department = new Department();
		department.setId(rs.getInt("id"));
		department.setName(rs.getString("name"));
		department.setLocation(rs.getString("location"));
		return department;

	}

	public Department getOne(int id) throws SQLException {
		Connection connection = Connecting.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from department where id=" + id);
			if (rs.next()) {
				return extractDepartmentFromResaltSet(rs);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	public List<Department> getAll() throws SQLException {
		Connection connection = Connecting.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from department");
			List<Department> departments = new ArrayList<Department>();
			while (rs.next()) {
				Department department = extractDepartmentFromResaltSet(rs);
				departments.add(department);
			}
			return departments;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	public boolean insertIntoTable(Department department) {
		Connection connection = Connecting.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("insert into department values(null,?,?)");
			ps.setString(1, department.getName());
			ps.setString(2, department.getLocation());
			int rowsUpdates = ps.executeUpdate();
			if (rowsUpdates == 1) {
				return true;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

	public boolean updateTable(Department department) {
		Connection connection = Connecting.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("update department set name=?, location=? where id=?");
			ps.setString(1, department.getName());
			ps.setString(2, department.getLocation());
			ps.setInt(3, department.getId());
			int rowsUpdates = ps.executeUpdate();
			if (rowsUpdates == 1) {
				return true;
			}
		} catch (Exception e) {
			e.getMessage();
		}

		return false;
	}

	public boolean deleteFromTable(int id) {
		Connection connection = Connecting.getConnection();
		try {
			Statement stmt = connection.createStatement();
			int i = stmt.executeUpdate("delete from department where id=" + id);
			if (i == 1) {
				return true;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

}
