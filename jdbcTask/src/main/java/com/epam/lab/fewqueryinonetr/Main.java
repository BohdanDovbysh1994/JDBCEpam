package com.epam.lab.fewqueryinonetr;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.epam.lab.driver.Connecting;

public class Main {

	public static void main(String[] args) throws SQLException {
		Connection connection = Connecting.getConnection();
		try {
			Statement stmt = connection.createStatement();
			stmt.addBatch("select * from exams");
			stmt.addBatch("select * from department");
			int[] result = stmt.executeBatch();
		} catch (Exception e) {
			e.getMessage();
		}

	}

}
