package com.epam.lab.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epam.lab.dao.ExamDao;
import com.epam.lab.driver.Connecting;
import com.epam.lab.entity.Exam;

public class ExamDaoImpl implements ExamDao {
	private Exam executeExamFromResultSet(ResultSet rs) throws SQLException {
		Exam exam = new Exam();
		exam.setId(rs.getInt("id"));
		exam.setStudentId(rs.getInt("student_id"));
		exam.setSubjectId(rs.getInt("subject_id"));
		exam.setDate(rs.getDate("date"));
		exam.setMark(rs.getInt("mark"));
		return null;
	}

	@Override
	public Exam getOne(int id) throws SQLException {
		try (Connection connection = Connecting.getConnection()) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from exam where id=" + id);
			if (rs.next()) {
				return executeExamFromResultSet(rs);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public List<Exam> getAll() throws SQLException {
		try (Connection connection = Connecting.getConnection()) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from exam");
			List<Exam> exams = new ArrayList<>();
			while (rs.next()) {
				Exam exam = executeExamFromResultSet(rs);
				exams.add(exam);
			}
			return exams;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public boolean insertIntoTable(Exam exam) {
		try (Connection connection = Connecting.getConnection()) {
			PreparedStatement ps = connection.prepareStatement("insert into exam values (null,?,?,?,?)");
			ps.setInt(1, exam.getStudentId());
			ps.setInt(2, exam.getSubjectId());
			ps.setDate(3, exam.getDate());
			ps.setInt(4, exam.getMark());
			int result = ps.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

	@Override
	public boolean updateTable(Exam exam) {
		try (Connection connection = Connecting.getConnection()) {
			PreparedStatement ps = connection
					.prepareStatement("update exam set student_id=?, subject_id=?, date=?, mark=? where id=?");
			ps.setInt(1, exam.getStudentId());
			ps.setInt(2, exam.getSubjectId());
			ps.setDate(3, exam.getDate());
			ps.setInt(4, exam.getMark());
			ps.setInt(5, exam.getId());
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
			int i = stmt.executeUpdate("delete from exam where id=" + id);
			if (i == 1) {
				return true;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}
}
