package com.myDemo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myDemo.user.User;
/**
 * Servlet implementation class DemoServelet
 */
@WebServlet("/DemoServelet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DemoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		/*
		 * if(session == null){ session = request.getSession(true); Integer
		 * hitCount = new Integer(0); session.setAttribute("count", hitCount);
		 */
				
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/user_database";
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_database", "root", "");

			System.out.println("Creating statement: ");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user");

			while (rs.next()) {
				String name = rs.getString("username");
				String id = rs.getString("email");

				System.out.println("user name " + name);
				System.out.println("email-id " + id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * Integer hitCount = (Integer) session.getAttribute("count");
	 * 
	 * hitCount = new Integer(hitCount.intValue() + 1);
	 * 
	 * session.setAttribute("count", hitCount);
	 * response.getWriter().print("Number of hits : " + hitCount.intValue());
	 */

	public Object hitCount(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public static User getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

}
