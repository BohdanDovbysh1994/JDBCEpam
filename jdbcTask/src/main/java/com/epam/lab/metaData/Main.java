package com.epam.lab.metaData;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.lab.driver.Connecting;
import com.mysql.cj.jdbc.DatabaseMetaData;

public class Main {

	public static void main(String[] args) throws SQLException {
		StringBuilder builderObj = new StringBuilder();
		DatabaseMetaData metaObj = (DatabaseMetaData) Connecting.getConnection().getMetaData();
		ResultSet resultSetObj = metaObj.getColumns("student", null, "student", "%");
		builderObj.append("student" + " Columns Are= (");
		while (resultSetObj.next()) {
			String columnName = resultSetObj.getString(4);
			String columnType = resultSetObj.getString(6);
			builderObj.append(columnName).append(" ");
			builderObj.append(columnType).append(", ");
			
		}
		builderObj.deleteCharAt(builderObj.lastIndexOf(" ")).deleteCharAt(builderObj.lastIndexOf(", ")).append(")").append("\n");
		System.out.println(builderObj.toString());
	}

}
