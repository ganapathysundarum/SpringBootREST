package com.fresco.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Validate {
	public static boolean checkUser(String email, String password) {
		boolean st = false;
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from users where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			st = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return st;
	}
}
