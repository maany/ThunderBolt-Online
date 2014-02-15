package com.controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.models.CatalogModel;

/**
 * Servlet implementation class Catalog
 */
@WebServlet("/catalog")
public class Catalog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Catalog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		// request header params
		String inCombo = request.getParameter("in").toString();
		String type = request.getParameter("type").toString();
		String orderByCombo = request.getParameter("orderBy");
		String sortBy = request.getParameter("sortBy");
		String keyword = request.getParameter("keyword");
		
		// send params to model to execute search query and return result set
		CatalogModel model = new CatalogModel();
		ResultSet booksTable = model.getResultSet(inCombo, type, orderByCombo, sortBy, keyword);
		// get no of results found as count
		int count =0;
		try {
			count = model.getResultCount(booksTable);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		// forwarding resultSet and result count to CatalogDisplay.jsp for display
	       session.setAttribute("renderTable", 1);
	       session.setAttribute("resultCount", count);
	       session.setAttribute("catalogTable",booksTable);
	       System.out.println("Catalog.java : using EncodeUrl to interceptted by /redirect nav id =4");
	       response.sendRedirect("redirect?navPage=4");
	       //RequestDispatcher rd = request.getRequestDispatcher("/redirect?navPage=4");
	       //rd.forward(request,response);
	}

}
