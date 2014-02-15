package com.thunderbolt;
import java.sql.*;
public class Connect {
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Connection con = openshift();
		return con;
	}
	private static Connection openshift() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://"+ System.getenv("OPENSHIFT_MYSQL_DB_HOST")+ ":"+System.getenv("OPENSHIFT_MYSQL_DB_PORT")+ "/library",System.getenv("OPENSHIFT_MYSQL_DB_USERNAME"),System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD"));
		return con;
	}

}

