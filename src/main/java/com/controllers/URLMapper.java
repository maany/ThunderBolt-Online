package com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		RequestDispatcher rd ;
		HttpSession session = request.getSession();
		int navPage = new Integer(request.getParameter("navPage")); 
		/*
		 * navPage is the content loaded in the div content of welcome.jsp
		 * Key :
		 * 2 - dashboard
		 * 3 - search page 
		 * 4 - search results page
		 * 41 - search results (watch is clicked)
		 * 100 - book.jsp
		 * 101 - book.jsp when (watch event is triggered)
		 * 102 - book.jsp when review is triggered.. see Review.java for detailed mapping..coz form is involved
		 * the navPage used in session.setAttribure() will be loaded in content
		 * request dispatcher changes the path followed by the request before ending up in welcome.jsp
		 */
		switch(navPage)
		{
		case 2: session.setAttribute("navPage",2); response.sendRedirect("dashboard"); break; 
		case 3: session.setAttribute("navPage",3);response.sendRedirect("welcome");break; // Catalog
		case 4 : System.out.println("URIMAPPER.java : FOUND CONDITION.navPage=4 MAPPING SUCCESSFUL"); // catalog_display
					session.setAttribute("navPage", 4);response.sendRedirect("welcome");break;
		case 41:System.out.println("inside URL Mapper for navPage 41");session.setAttribute("navPage",4);rd = request.getRequestDispatcher("watch");rd.forward(request,response);break;	// add watch from search results		
		case 100:session.setAttribute("navPage",100);rd = request.getRequestDispatcher("book");rd.forward(request,response);break;	// 100 = display book
		case 101:session.setAttribute("navPage",100);rd = request.getRequestDispatcher("watch");rd.forward(request,response);break;	
		case 102:session.setAttribute("navPage", 102);rd = request.getRequestDispatcher("review");rd.forward(request,response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
