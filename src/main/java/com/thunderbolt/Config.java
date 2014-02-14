package com.thunderbolt;
import java.sql.*;
public class Config {
	/**
	 * This method will return connection of the database resting in openshift
	 * @throws SQLException 
	 * @returns Connection con -> connection to the openshift db
	 */
	public static Connection getRemoteDB() throws SQLException
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("mysql://$OPENSHIFT_MYSQL_DB_HOST:$OPENSHIFT_MYSQL_DB_PORT/thunderbolt","adminGLgPs7R","wsCktYRn5H8g");
			 System.out.println("Connection estd with remote database");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static Connection getLocalDB() throws SQLException
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost/library","root","root123");
			 System.out.println("Connection estd with local database");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
