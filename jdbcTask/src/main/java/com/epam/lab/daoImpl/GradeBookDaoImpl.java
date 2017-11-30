package com.epam.lab.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epam.lab.dao.GradeBookDao;
import com.epam.lab.driver.Connecting;
import com.epam.lab.entity.GradeBook;

public class GradeBookDaoImpl implements GradeBookDao {
	private GradeBook extractGradeBookFromResultSet(ResultSet rs) throws SQLException {
		GradeBook gradeBook = new GradeBook();
		gradeBook.setId(rs.getInt("id"));
		gradeBook.setEntryDate(rs.getDate("entry_date"));
		gradeBook.setGroup(rs.getString("group"));
		gradeBook.setCourse(rs.getInt("course"));
		return gradeBook;
	}

	@Override
	public GradeBook getOne(int id) throws SQLException {
		try (Connection connection = Connecting.getConnection()) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from gradebook where id=" + id);
			if (rs.next()) {
				return extractGradeBookFromResultSet(rs);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public List<GradeBook> getAll() throws SQLException {
		try (Connection connection = Connecting.getConnection()) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from gradebook");
			List<GradeBook> gradeBooks = new ArrayList<>();
			while (rs.next()) {
				GradeBook gradeBook = extractGradeBookFromResultSet(rs);
				gradeBooks.add(gradeBook);
			}
			return gradeBooks;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public boolean insertIntoTable(GradeBook gradeBook) {
		try (Connection connection = Connecting.getConnection()) {
			PreparedStatement ps = connection.prepareStatement("insert into gradebook values (null,?,?,?)");
			ps.setDate(1, gradeBook.getEntryDate());
			ps.setString(2, gradeBook.getGroup());
			ps.setInt(3, gradeBook.getCourse());
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
	public boolean updateTable(GradeBook gradebook) {
		try (Connection connection = Connecting.getConnection()) {
			PreparedStatement ps = connection
					.prepareStatement("update gradebook set entry_date = ?, grop = ?, course = ? where id=?");
			ps.setDate(1, gradebook.getEntryDate());
			ps.setString(2, gradebook.getGroup());
			ps.setInt(3, gradebook.getCourse());
			ps.setInt(4, gradebook.getId());
			int rowUpdates = ps.executeUpdate();
			if (rowUpdates == 1) {
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
			int i = stmt.executeUpdate("delete from gradebook where id=" + id);
			if (i == 1) {
				return true;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

}
