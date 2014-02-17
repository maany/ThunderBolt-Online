package com.models;

import java.sql.*;

import com.thunderbolt.Connect;

public class DashboardModel {
	int roll;
	Connection con = null;
	ResultSet currentlyIssued = null;
	
	public DashboardModel()
	{
		// for dashboard.jsp for calculating row counts
	}
	public DashboardModel (int roll)
	{
		this.roll = roll;
		//creating connection
		try {
			con = Connect.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Return all the issue history for student. in jsp, classify as currently issued or prev issued
	 * @return
	 */
	
	public ResultSet getCurrentlyIssued()
	{
		PreparedStatement query;
		try {
			query = con.prepareStatement("select books.acc_no,books.title,books.author,books.publisher,issue.due_date,issue.issue_date from issue,books where issuer_id = ? and books.acc_no = issue.acc_no and issue.return_date is null");
			query.setInt(1,roll);
			printQuery(query);
			currentlyIssued = query.executeQuery();
			currentlyIssued.next();// to check if empty, catch exception here itself
		} catch (SQLException e) {
			System.out.println("DashBoardModel : getCurrentlyIssued: Exception : No entries found");
			e.printStackTrace();
		}
		return currentlyIssued;
		
	}
	public ResultSet getPreviouslyIssued()
	{
		PreparedStatement query;
		try {
			query = con.prepareStatement("select books.acc_no,books.title,books.author,books.publisher,issue.due_date,issue.return_date,issue.issue_date from books,issue where issuer_id = ? and books.acc_no = issue.acc_no and issue.return_date is not null");
			query.setInt(1,roll);
			printQuery(query);
			currentlyIssued = query.executeQuery();
			currentlyIssued.next();// to check if empty, catch exception here itself
		} catch (SQLException e) {
			System.out.println("DashBoardModel : getCurrentlyIssued: Exception : No entries found");
			e.printStackTrace();
		}
		return currentlyIssued;
		
	}
/**
 * return acc_no,title,author,publisher for books being watched
 * @return
 */
	public ResultSet getWatched()
	{
		ResultSet rs = null;
		try {
			PreparedStatement query = con.prepareStatement("select books.acc_no,books.title,books.author,books.publisher,books.status from books,watch_online where watch_online.roll_no = ? and books.acc_no = watch_online.acc_no");
			query.setInt(1,roll);
			rs = query.executeQuery();
			printQuery(query);
			rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	/**
	 * return acc_no,title,author,publisher for books reviewed by logged in user
	 * @return
	 */
	public ResultSet getReviewed()
	{
		ResultSet rs=null;
		try {
			PreparedStatement query = con.prepareStatement("select books.acc_no,books.title,books.author,books.publisher from books,review_online where review_online.roll_no=? and books.acc_no = review_online.acc_no");
			query.setInt(1,roll);
			printQuery(query);
			rs = query.executeQuery();
			rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	/**
	 * Return no of rows in result set
	 * @param rs
	 * @return
	 */
	public int getCount(ResultSet rs)
	{
		int count = 0;
		try {
			rs.beforeFirst();
			while(rs.next())
				count ++;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	private void printQuery(PreparedStatement query)
	{
		System.out.println("DashBoardModel : query : " + query.toString());
	}
}
