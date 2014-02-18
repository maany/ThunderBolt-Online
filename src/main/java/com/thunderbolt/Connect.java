package com.thunderbolt;
import java.sql.*;
public class Connect {
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Connection con = deployment();
		return con;
	}
	/**
	 * Connect to openshift mysql server database
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private static Connection deployment() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://"+ System.getenv("OPENSHIFT_MYSQL_DB_HOST")+ ":"+System.getenv("OPENSHIFT_MYSQL_DB_PORT")+ "/library",System.getenv("OPENSHIFT_MYSQL_DB_USERNAME"),System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD"));
		return con;
	}
	/**
	 * Connects to the local machine mysql database
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
			
	private static Connection production() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root123");
		return con;
	}

}

