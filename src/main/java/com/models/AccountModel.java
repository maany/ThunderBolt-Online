package com.models;
import java.sql.*;

import com.thunderbolt.Connect;
public class AccountModel {
	Connection con = null;
	int roll;
	public AccountModel(int roll)
	{
		this.roll = roll;
		try {
			con  = Connect.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet getDetails()
	{
		ResultSet rs = null;
		try {
			PreparedStatement query = con.prepareStatement("select * from student where roll_no = ?");
			query.setInt(1,roll);
			rs = query.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}
