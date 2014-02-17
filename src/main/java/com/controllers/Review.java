package com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.models.ReviewModel;

/**
 * Servlet implementation class Review
 */
@WebServlet("/review")
public class Review extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Review() {
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
		int acc = new Integer(request.getParameter("acc"));
		RequestDispatcher rd =null ;
		String action = request.getParameter("action");
		System.out.println("Review: inside controller : action = " + action);
		switch(action)
		{
		case "new":  session.setAttribute("navPage",102);rd = request.getRequestDispatcher("/welcome.jsp");rd.forward(request, response);break;
		case "edit" : session.setAttribute("navPage",102);rd = request.getRequestDispatcher("/welcome.jsp");rd.forward(request, response);break;
		case "delete" : session.setAttribute("navPage",100);delete(acc,roll);rd = request.getRequestDispatcher("/welcome.jsp");rd.forward(request, response);break;
		case "addButton" : System.out.println("Add Button Detected");session.setAttribute("navPage",100);add(request,roll,acc);rd = request.getRequestDispatcher("/welcome.jsp");rd.forward(request, response);break;
		case "editButton" : session.setAttribute("navPage",100);edit(request,roll,acc);rd = request.getRequestDispatcher("/welcome.jsp");rd.forward(request, response);break;
		}
	}
	private void delete(int acc,int roll)
	{
		ReviewModel student = new ReviewModel(acc);
		student.deleteReview(roll);
	}
	private void add(HttpServletRequest request,int roll,int acc)
	{
		ReviewModel student = new ReviewModel(acc);
		student.addReview(request.getParameter("review"),roll);
	}
	private void edit(HttpServletRequest request,int roll,int acc)
	{
		ReviewModel student = new ReviewModel(acc);
		student.editReview(request.getParameter("review"),roll);
	}

}
