package com.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.thunderbolt.Connect;

public class CatalogModel {
	Connection con = null;
	PreparedStatement query=null;
	String queryString;
	ResultSet booksTable = null;
	public CatalogModel()
	{
	// connecting to database
	try {
		con = Connect.getConnection();
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		System.out.println("EXCEPTION FROM CatalogModel.java");
		e.printStackTrace();
	}
	}
	
	/**
	 * return no of search results
	 * @param rs
	 * @return
	 * @throws SQLException 
	 */
	public static int proceedFlag=0;
	public int getResultCount(ResultSet rs) throws SQLException
	{
		int count=0;
		rs.beforeFirst();
		while(rs.next())
		count++;
		return count;
	}
	public ResultSet getResultSet(String inCombo,String type,String orderByCombo,String sortBy,String keyword)
	{
		try{
	        queryString = "SELECT acc_no,title,author,publisher,subject,status FROM books WHERE ";
	        queryString += inCombo;
	        if(type.compareTo("like")==0)
	            queryString += " LIKE ? ";//GROUP BY " + groupByCombo.getSelectedItem().toString() + " ORDER BY " + orderByCombo.getSelectedItem().toString() ;
	        else if (type.compareTo("exact")==0)
	            queryString += " = ? ";//GROUP BY " + groupByCombo.getSelectedItem().toString() + " ORDER BY " + orderByCombo.getSelectedItem().toString() ;
	       
	        queryString += " ORDER BY " + orderByCombo;
	       
	       if (sortBy.compareTo("ASC")==0)
	            queryString += " ASC";
	       else if (sortBy.compareTo("DESC")==0)
	            queryString +=" DESC";
	       
	       query = con.prepareStatement(queryString);
	        
	        if(keyword.length()!=0)
	        {
	        if(type.compareTo("like")==0)
	            query.setString(1,"%"+keyword+"%");
	        else if (type.compareTo("exact")==0)
	            query.setString(1,keyword);
	        }
	        else // IF KEYWORD  IS LEFT EMPTY THEN ENTIRE DATABASE IS LOOKED UP..FAILES IS EXACT COMBO IS SELECTED.
	        {
	            query.setString(1,"%");
	        }
	       System.out.println(query.toString());// TODO remove
	       booksTable = query.executeQuery();
	        /**
	         * mapping status to available will be done in catalog.jsp while printing 
	         */
		    }catch(Exception e)
	        {
	        	System.out.println("Exception from Catalog controller");
	        	e.printStackTrace();
	        }
		return booksTable;
	}

}
