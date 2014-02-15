package com.models;
import java.sql.*;

import com.thunderbolt.Connect;
/**
 * This class provides values from backend to welcome.jsp
 * @author MAYANK
 *
 */
public class WelcomeModel {
private String firstName;
private ResultSet rs;
private Connection con ;
/**
 * connect to db and initialize varz
 * @param roll
 * @throws ClassNotFoundException
 * @throws SQLException
 */
public WelcomeModel(int roll) 
{
	//connect to db
	try {
		con= Connect.getConnection();
		PreparedStatement query = con.prepareStatement("select `First Name` from student where roll_no = ?");
		query.setInt(1,roll);
		rs = query.executeQuery();
		rs.next();
		//initializing varz
		firstName = rs.getString(1);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}
/**
 * first name of current session returned
 * @return
 */
public String getFirstName()
{
	return firstName;
}
	
}
