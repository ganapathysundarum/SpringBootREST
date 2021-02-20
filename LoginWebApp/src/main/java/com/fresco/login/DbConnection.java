package com.fresco.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static Connection getConnection() {
        Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return con;
	}

	public static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
		}
	}

}
