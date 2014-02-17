package com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.models.WatchModel;

/**
 * Servlet implementation class Watch
 */
@WebServlet("/watch")
public class Watch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Watch() {
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
		int acc = new Integer(request.getParameter("acc"));
		int roll = new Integer(session.getAttribute("roll").toString());
		WatchModel student = new WatchModel(roll);
		String action = request.getParameter("action");
		if(action.compareTo("add")==0)
			student.addWatch(acc);
		else if(action.compareTo("remove")==0)
			student.unWatch(acc);
		RequestDispatcher rd = request.getRequestDispatcher("/welcome.jsp");
		rd.forward(request,response);
	}

}
