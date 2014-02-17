package com.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class URLMapper
 */
@WebServlet("/redirect")
public class URLMapper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public URLMapper() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int navPage = new Integer(request.getParameter("navPage"));
		switch(navPage)
		{
		case 2: session.setAttribute("navPage",2); response.sendRedirect("dashboard"); break; 
		case 3: session.setAttribute("navPage",3);response.sendRedirect("welcome");break; // Catalog
		case 4 : System.out.println("URIMAPPER.java : FOUND CONDITION.navPage=4 MAPPING SUCCESSFUL"); // catalog_display
					session.setAttribute("navPage", 4);response.sendRedirect("welcome");break;
					
		
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
