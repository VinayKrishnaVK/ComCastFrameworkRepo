package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {

	Connection conn;
	
	public void getDbConnection(String url,String username, String password) throws Throwable {
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			conn = DriverManager.getConnection(url,username,password);
		}
		catch (Exception e) {
		}
	}
	public void getDbConnection() throws Throwable {
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","");
		}
		catch (Exception e) {
		}
	}
	public void closeDbConnection() throws SQLException {
		conn.close();
	}
	public ResultSet executeSelectQuery(String query) throws Throwable {
		ResultSet result = null;
		try {
			Statement stat = conn.createStatement();
			result = stat.executeQuery(query);
			
		}
		catch (Exception e) {
		}
		return result;
		
	}
	public int executeNonSelectQuery(String query) throws SQLException {
			int result=0;
		try {
			Statement stat = conn.createStatement(); 
			result=stat.executeUpdate(query);
		}
		catch (Exception e) {
		}
		return result;
	}
}
