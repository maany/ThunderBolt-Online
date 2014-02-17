package com.controllers;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.models.DashboardModel;

/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dashboard() {
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
		int roll = new Integer(session.getAttribute("roll").toString());
		DashboardModel student = new DashboardModel(roll);
		//books currently issued
		ResultSet currentlyIssued =student.getCurrentlyIssued() ;
		//books previously issued
		ResultSet previouslyIssued = student.getPreviouslyIssued();
		//books on watch
		ResultSet watched = student.getWatched();
		//My Reviews
		ResultSet reviewed = student.getReviewed();
		
		//adding result sets to session
		session.setAttribute("dashCurrentlyIssued",currentlyIssued);
		session.setAttribute("dashPreviouslyIssued",previouslyIssued);
		session.setAttribute("dashWatched",watched);
		session.setAttribute("dashReviewed",reviewed);
		// navPage was set to 2 by URLMapper and request was brought here. After processing and modifying session, request is forwarded to welcome.jsp which now loads with dashboard.
		RequestDispatcher rd = request.getRequestDispatcher("/welcome.jsp");
		rd.forward(request,response);
	}

}
