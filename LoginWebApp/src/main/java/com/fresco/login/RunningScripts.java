package com.fresco.login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;

import javax.servlet.ServletContextEvent;

import org.apache.ibatis.jdbc.ScriptRunner;

public class RunningScripts implements javax.servlet.ServletContextListener {
	public void contextInitialized(ServletContextEvent sce) {
		Connection con = DbConnection.getConnection();
		ScriptRunner sr = new ScriptRunner(con);
		Reader reader;
		try {
			reader = new BufferedReader(new FileReader("db.sql"));
			con.setAutoCommit(true);
			sr.runScript(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
}