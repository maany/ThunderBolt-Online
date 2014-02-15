package com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.models.CatalogModel;
import com.models.WelcomeModel;

/**
 * Servlet implementation class Welcome
 */
@WebServlet(description = "instantiate model and set session values that can be used by jsp", urlPatterns = { "/welcome" })
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
        super();
        System.out.println("inside welcome controller");
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
		// get roll no from session
		int roll = new Integer(session.getAttribute("roll").toString());
		// store details for current student in bean
		WelcomeModel welcomeBean = new WelcomeModel(roll);
		// get first name and put it into session
		String firstName = welcomeBean.getFirstName();
		session.setAttribute("firstName",firstName);
		
		// hand over control to view i.e jsp and initialize flags
		RequestDispatcher rd = request.getRequestDispatcher("/welcome.jsp");
		CatalogModel.proceedFlag=0; // if request to catalog goes from this page, then flag value is 0;
		rd.forward(request,response);
	}

}
