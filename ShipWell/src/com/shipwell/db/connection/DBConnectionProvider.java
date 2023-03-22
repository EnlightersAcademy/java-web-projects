package com.shipwell.db.connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class DBConnectionProvider {

	private static Connection conn = null;

	static {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		} catch(Exception exe) {
			System.out.println("RegisterDriver error : " +  exe.getMessage());
			exe.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception {
		try {
			if (conn == null || conn.isClosed()) {
				conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/shipwell", "root", "root");
			}
		} catch (Exception e) {
			System.out.println(" database error:" + e.getMessage());
			throw e;
		}
		return conn;

	}
	
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeStatementAndResultSets(Statement statement, ResultSet resultSet) {
		try {
		if(statement != null) {
			statement.close();
		}
		if(resultSet != null) {
			resultSet.close();
		}
		} catch(Exception exe) {
			System.out.println("Error while closing statement and resultset");
			exe.printStackTrace();
		}
	}
}

