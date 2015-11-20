package com.wipro.timetracker.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static String driver = "org.apache.derby.jdbc.ClientDriver";
	private static String url = "jdbc:derby://localhost:1527/timetracker";

	static {
		try {
			Class.forName(driver);
			System.out.println("Driver Loaded...");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	public static Connection getCon() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url);
			System.out.println("Connection to timetracker establish...");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

	public static void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
