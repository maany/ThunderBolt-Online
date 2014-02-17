package com.models;

import java.sql.*;

import com.thunderbolt.Connect;

public class WatchModel {
	int roll;
	Connection con;
	public WatchModel(int roll)
	{
		this.roll = roll;
		try {
			con = Connect.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * returns true if student is watching the book;
	 * @param acc
	 * @return
	 */
	public boolean getWatchStatus(int acc)
	{
		boolean status = false;
		try {
			java.sql.PreparedStatement query = con.prepareStatement("select * from watch_online where roll_no = ? and acc_no = ?");
			query.setInt(1,roll);
			query.setInt(2,acc);
			System.out.println(query.toString());
			ResultSet rs = query.executeQuery();
			if(rs.next())
			status = true;
		} catch (SQLException e) {
			// if exception means now watching
			System.out.println ("WatchModel : Not Watching : " + acc + " Message : " + e.getMessage());
	    }
		return status;
	}
	
	public void addWatch(int acc)
	{
		try {
			PreparedStatement query = con.prepareStatement("insert into watch_online(acc_no,roll_no) values(?,?)");
			query.setInt(1, acc);
			query.setInt(2,roll);
			query.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void unWatch(int acc)
	{
		try {
			PreparedStatement query = con.prepareStatement("delete from watch_online where roll_no=? and acc_no=?");
			query.setInt(2, acc);
			query.setInt(1,roll);
			query.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
