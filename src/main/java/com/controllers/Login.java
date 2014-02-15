package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thunderbolt.Connect;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		RequestDispatcher rd ;
		HttpSession session;
		ResultSet rs = null;
		Connection con = null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//retrieve request header values
		Integer roll = Integer.parseInt(request.getParameter("roll"));
		String pass = request.getParameter("pass");
		//connect to database
		try {
			con = Connect.getConnection();
			if(con!=null)
			System.out.println("Connection successful from Login.java");
		} catch (SQLException e) {
			System.out.println("Connection to database failed from Login.java");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// querying
		try {
			PreparedStatement query = con.prepareStatement("select * from student_online where roll_no = ? and password=?");
			query.setInt(1, roll);
			query.setString(2,pass);
			rs = query.executeQuery();
			System.out.println(query.toString());
			rs.next();
			// entry found.. start session + forward to /welcome.jsp
			if(rs.getString("password").length()!=0)
			{
				System.out.println("Login.java = Details for query \n" + query.toString()+ "\n roll from db " + rs.getInt("roll_no") + " and password" + rs.getString("password"));
				session = request.getSession();
				session.setAttribute("roll",roll);
				rd = request.getRequestDispatcher("/welcome");
				rd.forward(request,response);
			}
			//entry not found.. re-login/sign up
			/*else{
				request.setAttribute("failed","true");
				rd = request.getRequestDispatcher("/login.jsp");
				rd.forward(request,response);
			}*/
		} catch (SQLException e) {
			e.printStackTrace();
			if(e.getMessage().compareTo("Illegal operation on empty result set.")==0)
			{
				request.setAttribute("failed","true");
				out.println("<div class='error' align='center'>"
						+"Roll Number or Password incorrect"
						+ "</div><br>");
				rd = request.getRequestDispatcher("/login.jsp");
				rd.include(request,response);
			}
			else
			{
				out.println("Internal Server Error from Login servlet. Please contact admin");
			}
			
		}
		
	}

}
