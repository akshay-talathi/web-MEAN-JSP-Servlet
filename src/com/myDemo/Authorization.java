package com.myDemo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myDemo.user.User;

@WebServlet("/Authorization")
public class Authorization extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Authorization() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.getOutputStream().println("Yo");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		Sha1 s = new Sha1();

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/user_database", "root", "");
			pass = s.Sha1(pass);

			Statement statement = connection.createStatement();

			ResultSet rs = statement
					.executeQuery("select * from user where username='" + name
							+ "' and password='" + pass + "';");
		     //rs = connection.createStatement().executeQuery("select * from user");
			User user = null;
			while (rs.next()) {
				user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));								
				
				//response.getOutputStream().println("successfully logged in! :)");
				HttpSession session=request.getSession();  
		        session.setAttribute("user",name);  
				//response.getOutputStream().println("successfully logged in! :)");

				//response.sendRedirect("order.jsp");
		        request.getRequestDispatcher("demo.jsp").include(request, response);  

			}	
			if(user == null){
				response.getOutputStream().println("failed to login...Please try again");
				response.sendRedirect("index.jsp");}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
