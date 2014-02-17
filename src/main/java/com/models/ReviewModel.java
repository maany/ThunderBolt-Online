package com.models;
import java.sql.*;

import com.thunderbolt.Connect;
public class ReviewModel {
	int acc;
	Connection con;
	public ReviewModel(int acc)
	{
		this.acc=acc;
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
	public void addReview(String review,int roll)
	{
		try {
			PreparedStatement query = con.prepareStatement("insert into review_online(acc_no,roll_no,review) values(?,?,?)");
			query.setInt(1, acc);
			query.setInt(2, roll);
			query.setString(3,review);
			query.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public void deleteReview(int roll)
	{
		try {
			PreparedStatement query = con.prepareStatement("delete from review_online where roll_no = ?");
			query.setInt(1, roll);
			query.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void editReview(String review,int roll)
	{
		try {
			PreparedStatement query = con.prepareStatement("update review_online set review = ? where acc_no =? and roll_no =?");
			query.setString(1,review);
			query.setInt(3, roll);
			query.setInt(2, acc);
			query.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * used to update form field when opened in edit mode
	 * @param roll
	 * @return
	 */
	public String getReview(int roll)
	{
		String review="";
		try {
			PreparedStatement query = con.prepareStatement("select review from review_online where acc_no =? and roll_no=?");
			query.setInt(1, acc);
			query.setInt(2, roll);
			ResultSet rs = query.executeQuery();
			if(rs.next())
				review = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return review;
	}
	/**
	 * return name of the book whose review is being mentioned. used in <h3>of jsp
	 * @return
	 */
	public String getTitle()
	{
		String title="";
		try {
			PreparedStatement query = con.prepareStatement("select title from books where acc_no =?");
			query.setInt(1,acc);
			ResultSet rs = query.executeQuery();
			if(rs.next())
				title = rs.getString("title");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return title;
	}
}
