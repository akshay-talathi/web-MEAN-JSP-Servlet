package com.myDemo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myDemo.Sha1;
/**
 * Servlet implementation class Check
 */
@WebServlet("/Check")
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Check() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getOutputStream().println("hello");// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		String email = request.getParameter("email");
		System.out.println(name);
		Sha1 s = new Sha1();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/user_database", "root", "");
				pass = s.Sha1(pass);
				String query = "insert into user (username, password, email) values (?,?,?)";
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setString(1, name);
				statement.setString(2, pass);
				statement.setString(3, email);
				System.out.println("query formed = "+query);
				
				System.out.println("user name  "+name);
				int rows = statement.executeUpdate();
				System.out.println("rows affected:" + rows);
				response.sendRedirect("index.jsp");
		        //request.getRequestDispatcher("index.jsp").include(request, response);  

			     //rs = connection.createStatement().executeQuery("select * from user");
				
					//response.sendRedirect("Checking.java");
				
					
				
				
			} catch (Exception e ) {

				e.printStackTrace();
			} 
			
			
		

			
		
	}

}
