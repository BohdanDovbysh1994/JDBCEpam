package com.epam.lab.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epam.lab.dao.SubjectDao;
import com.epam.lab.driver.Connecting;
import com.epam.lab.entity.Subject;

public class SubjectDaoImpl implements SubjectDao {
	private Subject extractSubjectFromResaltSet(ResultSet rs) throws SQLException {
		Subject subject = new Subject();
		subject.setId(rs.getInt("id"));
		subject.setName(rs.getString("name"));
		subject.setDescription(rs.getString("description"));
		return subject;

	}

	@Override
	public Subject getOne(int id) throws SQLException {

		try (Connection connection = Connecting.getConnection()) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from subject where id=" + id);
			if (rs.next()) {
				return extractSubjectFromResaltSet(rs);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public List<Subject> getAll() throws SQLException {
		try (Connection connection = Connecting.getConnection()) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from subject");
			List<Subject> subjects = new ArrayList<Subject>();
			while (rs.next()) {
				Subject subject = extractSubjectFromResaltSet(rs);
				subjects.add(subject);
			}
			return subjects;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public boolean insertIntoTable(Subject subject) {
		try (Connection connection = Connecting.getConnection()) {
			PreparedStatement ps = connection.prepareStatement("insert into subject values(null,?,?)");
			ps.setString(1, subject.getName());
			ps.setString(2, subject.getDescription());
			int rowsUpdates = ps.executeUpdate();
			if (rowsUpdates == 1) {
				return true;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

	@Override
	public boolean updateTable(Subject subject) {
		try (Connection connection = Connecting.getConnection()) {
			PreparedStatement ps = connection.prepareStatement("update subject set name=?, description=? where id=?");
			ps.setString(1, subject.getName());
			ps.setString(2, subject.getDescription());
			ps.setInt(3, subject.getId());
			int rowsUpdates = ps.executeUpdate();
			if (rowsUpdates == 1) {
				return true;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

	@Override
	public boolean deleteFromTable(int id) {
		try (Connection connection = Connecting.getConnection()) {
			Statement stmt = connection.createStatement();
			int i = stmt.executeUpdate("delete from subject where id=" + id);
			if (i == 1) {
				return true;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

}
