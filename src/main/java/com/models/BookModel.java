package com.models;

import java.sql.*;
import java.util.HashMap;

import com.thunderbolt.Connect;

public class BookModel {
	int acc;
	Connection con;
	public BookModel(int acc)
	{
		this.acc=acc;
		//this.roll = roll;
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
	 * return a hashmap as [review,full name]=>roll_no
	 * @return
	 */
	public HashMap<String[],Integer> getReviews()
	{
		String[] review=null;
		int roll;
		HashMap<String[],Integer> reviews = new HashMap<String[],Integer>();
		try {
			PreparedStatement query = con.prepareStatement("select review_online.review,CONCAT(student.`First Name`,' ',student.`Last Name`) as name,student.roll_no from review_online,student where review_online.acc_no = ? and student.roll_no = review_online.roll_no");
			query.setInt(1,acc);
			ResultSet rs = query.executeQuery();
			while(rs.next())
			{
				roll = rs.getInt("roll_no");
				review= new String[2];
				review[0]=rs.getString(1);
				review[1]=rs.getString(2); // catenated name
				reviews.put(review,roll);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reviews;
	}
	/**
	 * no of people watching current book
	 * @return
	 */
	public int getWatchCount()
	{
		int count=0;
		try {
			PreparedStatement query = con.prepareStatement("select * from watch_online where acc_no =?");
			query.setInt(1,acc);
			ResultSet rs = query.executeQuery();
			while(rs.next())
				count ++;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public int getReviewCount()
	{
		int count=0;
		try {
			PreparedStatement query = con.prepareStatement("select * from review_online where acc_no =?");
			query.setInt(1,acc);
			ResultSet rs = query.executeQuery();
			while(rs.next())
				count ++;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	/**
	 * returns boolean for if a student is watching this bool or not
	 * @param roll
	 * @return
	 */
	public boolean isWatching(int roll)
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
			System.out.println ("BookModel : Not Watching : " + roll + " Message : " + e.getMessage());
	    }
		return status;
	}
	/**
	 * has this book been reviewed by a given student?
	 * @param roll
	 * @return
	 */
	public boolean isReviewed(int roll)
	{
		boolean status = false;
		try {
			java.sql.PreparedStatement query = con.prepareStatement("select * from review_online where roll_no = ? and acc_no = ?");
			query.setInt(1,roll);
			query.setInt(2,acc);
			System.out.println(query.toString());
			ResultSet rs = query.executeQuery();
			if(rs.next())
			status = true;
		} catch (SQLException e) {
			// if exception means now watching
			System.out.println ("BookModel : Not Reviewed : " + roll + " Message : " + e.getMessage());
	    }
		return status;
	}
	public ResultSet getDetails()
	{
		ResultSet rs = null;
		try {
			PreparedStatement query = con.prepareStatement("select * from books where acc_no = ?");
			query.setInt(1,acc);
			rs=query.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
