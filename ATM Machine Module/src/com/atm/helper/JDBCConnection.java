package com.atm.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	private static Connection conn = null;
	
	public static Connection createConnection() throws ClassNotFoundException,
	SQLException
	{
		conn = DriverManager.getConnection(""
				+ "jdbc:mysql://localhost:3306/ATM","root","4591");
		return conn;
		
	}
	
	public static void closeConnection() throws SQLException
	{
		conn.close();
	}
}
